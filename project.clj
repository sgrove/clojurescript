(defproject clojurescript "0.1.0-SNAPSHOT"
  :plugins [[lein-cljsbuild "0.3.0"]
            [lein-bikeshed "0.1.0"]
            [lein-pprint "1.1.1"]
            [lein-ring "0.8.2"]]
  :description "Blocker"
  :url "http://trapm.posterous.com/"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/data.json "0.2.2"]
                 [org.clojure/tools.reader "0.7.5"]
                 [org.clojure/tools.trace "0.7.5"]
                 [com.google.javascript/closure-compiler "r2180"]
                 [org.clojure/google-closure-library "0.0-2029-2"]
                 [org.mozilla/rhino "1.7R4"]]
  :source-paths ["src/clj"
                 "src/cljs"]
  :min-lein-version "2.0.0"
  :jvm-opts ~(when (System/getenv "CI") ["-Xmx1024m"])
  ;:hooks [leiningen.cljsbuild]
  ;:repositories [["Sauce Labs" "http://repository-saucelabs.forge.cloudbees.com/release/"]]
  :resource-paths ["resources/public"]
  :profiles {:prod {:resource-paths ["config/prod"]}
             :dev {:resource-paths ["config/dev"]
                   :source-paths ["test" "dev"]
                   :dependencies [[midje "1.4.0"]
                                  [org.clojure/tools.namespace "0.2.3"]
                                  [org.clojure/java.classpath "0.2.0"]]
                   :plugins [[lein-midje "2.0.1"]]}})
