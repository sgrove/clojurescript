(ns client.simple)

(defn subtract [targets]
  (let [one (first targets)
        second (last targets)]
    ;(if 1)
    (- one second)))

(defn opttest [a & b]
  b)

(defn add [x y]
  (+ x y))

