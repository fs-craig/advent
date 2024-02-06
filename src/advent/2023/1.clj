(ns advent.2023.1
  (:require [clojure.string :as string]
            [clojure.test :as test :refer :all]))

(def resources "resources/2023/1/")
(def example-1 (str resources "example_1.txt"))
(def part-1 (str resources "part_1.txt"))
(def example-1-2 (str resources "example_1_2.txt"))

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
  (->> (keys digit-words)
       (interpose "|")
       (vec)
       (#(conj % "))"))
       (apply str "(?=(\\d|")
       (re-pattern)))

(def words [worded-regex second])

(def digit-regex #"\d")
(def digits [digit-regex identity])

(defn word->digit
  [v]
  (if (= (count v) 1)
    v
    (digit-words v)))

(defn calibration [[regex compf] s]
  (let [digits (map (comp word->digit compf) (re-seq regex s))]
    (read-string (str (first digits) (last digits)))))

(defn sum-calibration [[regex compf :as ins] path]
  (->> (string/split (slurp path) #"\n")
       (map (partial calibration ins))
       (reduce +)))

(deftest check-answers
  (is (= (sum-calibration digits example-1) example-1-answer))
  (is (= (sum-calibration digits part-1) part-1-answer))
  (is (= (sum-calibration words example-1-2) example-1-2-answer))
  (is (= (sum-calibration words part-1) part-2-answer)))
