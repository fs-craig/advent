(ns advent.2023.1
  (:require [clojure.string :as string]
            [clojure.test :as test :refer :all]))

(def resources "resources/2023/1/")
(def example-1 (str resources "example_1.txt"))
(def part-1 (str resources "part_1.txt"))
(load-file (str resources "answers.clj"))

(defn calibration [s]
  (let [digits (re-seq #"\d" s)]
    (read-string (str (first digits) (last digits)))))

(defn sum-calibration [path]
  (->> (string/split (slurp path) #"\n")
       (map calibration)
       (reduce +)))

(deftest check-answers
  (is (= (sum-calibration example-1) example-1-answer))
  (is (= (sum-calibration part-1) part-1-answer)))
