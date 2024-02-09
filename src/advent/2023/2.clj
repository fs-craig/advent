(ns advent.2023.2
  (:require [clojure.string :as string]
            [clojure.test :as test :refer :all]))

(def resources "resources/2023/2/")
(def example-1 (str resources "example_1.txt"))
(load-file (str resources "answers.clj"))


;;the number of each block in a bag (bag) is denoted by {:red 3 :blue 4
;;:green 5}

;;defn possible-set? checks to see if a map (cube-set) of cubes is
;;possible given the bag
;;then defn possible-game? to see if a game is possible. Games are
;;vectors of cube-sets
;;next time: decide whether to parse the game id or map-indexed.  For
;;now, map-indexed is probably easier.

(defn balls->map-e "\"3 blue\""
  [ball-str]
  (let [[num ball] (string/split ball-str #" ")]
    [ball (read-string num)]))

(defn draw->map [draw-str]
  (->> (string/split draw-str #", ")
       (map balls->map-e)
       (reduce conj {})))

(defn map-in [f xs]
  (map #(map f %) xs))
  
(defn parse-input [path]
  (->> (slurp path)
       (#(string/split % #"\n")  )
       (map #(string/split % #": "))
       (map rest)
       (map first)
       (map #(string/split % #"; "))
       (map-in draw->map)))
       
