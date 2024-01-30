(ns advent.2023.1
  (:require [clojure.string :as string]
            [clojure.test :as test :refer :all]))

(def resources "resources/2023/1/")
(def example-1 (str resources "example_1.txt"))
(def part-1 (str resources "part_1.txt"))
(load-file (str resources "answers.clj"))
(def digit-words
  {"one" 1
   "two" 2
   "three" 3
   "four" 4
   "five" 5
   "six" 6
   "seven" 7
   "eight" 8
   "nine" 9})

(def worded-regex
  (re-pattern (apply str "\\d|" (interpose "|" (keys digit-words)))))

(def digit-regex #"\d")

(defn word->digit
  [v]
  (if (= (count v) 1)
    v
    (digit-words v)))
      
(defn calibration [regex s]
  (let [digits (map word->digit (re-seq regex s))]
    (read-string (str (first digits) (last digits)))))

(defn sum-calibration [regex path]
  (->> (string/split (slurp path) #"\n")
       (map (partial calibration regex))
       (reduce +)))

(deftest check-answers
  (is (= (sum-calibration digit-regex example-1) example-1-answer))
  (is (= (sum-calibration digit-regex part-1) part-1-answer)))

;;end of day Tuesday
;;worded-regex isn't working right.  what happens if 9 inside of nine?
