(ns hello.core
  (:require [hello.foo.bar :as bar]))

(defn ^{:export greet} greet [n]
  (str "Hello " n))

(defn ^:export sum [xs]
  (bar/sum xs))

(def supertest 10)

(def super-test 99)

(defn find-a-way [ways]
  (let [x 10
        sunny-day "sunny"]
    (doseq [everyday [1]]
      (everyday)
      (throw (js/Error. "Welcome to my sunny day, better day")))))


(defn calendar [day month year]
  (let [max-rand 23]
    ;(find-a-way y)
    (let [ytd (str day "-" month "-" year)]
      (.log js/console "Horrrray~ " ytd)
      (.log js/console "Day: " day)
      (.log js/console "month: " month)
      (.log js/console "Year: " year)
      (str ytd "-" (rand-int max-rand)))))

;(calendar 34)

(defn multi-symbol-test [age first-name last-name address callback signal]
  (let [max-rand (rand)]
    (let [person (str first-name " " last-name ", lives at " address, ", " age "years old")
          example-failure 1]
      (.log js/console "Name: " (str first-name last-name))
      (.log js/console "Address: " address)
      (.log js/console "Age: " age)
      (.log js/console "Person: " person)
      ;(age "hi")
      ;(example-failure "hi")
      (callback age first-name last-name address signal))))

;(caledar 299)



;(find-a-way "everyway")

(multi-symbol-test 28 "Sean" "Grove" "627 Corbett Ave. #5" #(.log js/console "Logging this") "signal")

