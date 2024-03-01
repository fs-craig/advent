(ns advent.2023.3
  (:require [clojure.string :as string]
            [clojure.test :as test :refer :all]))

(def resources "resources/2023/3/")
(def example-1 (str resources "example_1.txt"))
(load-file (str resources "answers.clj"))

;;rewrite this for rows since this won't work with >10 items in first row
(defn item-at [rows row col]
 (nth items (+ row col)))

;;pull the rows into get-rows
;;use item-at here.
(defn index-items [path]
  (let [rows (->> (slurp path)
                  (string/split-lines))]
    (for [i (range (count rows))
          j (range (count (first rows)))]
      [i j (str (nth (nth rows i) j))])))

(deftest check-answers
  (is (= example-1
         example-1-answer)))
