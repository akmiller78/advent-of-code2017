(ns advent-of-code.day-01
  (:require [clojure.java.io :as io]))


(defn get-input
  []
  (->> (-> "day_01/input.txt" io/resource slurp)
       (map (comp read-string str))))

(defn captcha-result
  [col]
  (let [digits (mapv #(vector %1 %2)
                     col
                     (rest (take (+ 1 (count col)) (cycle col))))]
    (->> digits
         (filter (partial apply =))
         (map first)
         (reduce +))))


