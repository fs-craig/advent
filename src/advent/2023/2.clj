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
