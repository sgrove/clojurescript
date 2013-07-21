(ns user
  (:refer-clojure :exclude [munge macroexpand-1])
  (:require [cljs.closure :as cljsc]
            [clojure.java.io :as io]
            [clojure.string :as string]
            [cljs.tagged-literals :as tags]
            [cljs.analyzer :as ana]
            [cljs.compiler :refer :all]
            [clojure.tools.namespace.repl :refer [refresh]]))

(defn test-source-maps [src & [opts]]
  (binding [ana/*cljs-ns* 'cljs.user
            *cljs-source-map* (atom (sorted-map)) 
            *cljs-gen-line* (atom 0)
            *cljs-gen-col* (atom 0)]
    (loop [forms (ana/forms-seq src)
           ns-name nil
           deps nil]
      (if (seq forms)
        (let [env (ana/empty-env)
              ast (ana/analyze env (first forms))]
          (do (emit ast)
              (if (= (:op ast) :ns)
                (recur (rest forms) (:name ast) (merge (:uses ast) (:requires ast)))
                (recur (rest forms) ns-name deps))))
        (merge
          {:ns (or ns-name 'cljs.user)
           :provides [ns-name]
           :requires (if (= ns-name 'cljs.core) (set (vals deps)) (conj (set (vals deps)) 'cljs.core))
           :lines @*cljs-gen-line*}
          (when (:source-map opts)
            {:source-map @*cljs-source-map*}))))))
