(ns advent.2023.3
  (:require [clojure.string :as string]
            [clojure.test :as test :refer :all]))

(def resources "resources/2023/3/")
(def example-1 (str resources "example_1.txt"))
(load-file (str resources "answers.clj"))

;;
(deftest check-answers
  (is (= example-1
         example-1-answer)))
