(ns advent.2023.2
  (:require [clojure.string :as string]
            [clojure.test :as test :refer :all]
            [clojure.set :as s]))

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

;;parsing-----------------------------------------------
(defn balls->map-e "\"3 blue\""
  [ball-str]
  (let [[num ball] (string/split ball-str #" ")]
    [(keyword ball) (read-string num)]))

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

;;Determining if games are valid----------------

(defn in-bounds? [check [color num-balls]]
  (let [num-check (check color)]
    (and (>= num-balls 0)
         (<= num-balls num-check))))

(defn draw-in-bounds? [in-draw check]
  (every? (partial in-bounds? check) in-draw))

(defn possible-draw? [in-draw check]
  (and (s/subset? (set (keys in-draw)) (set (keys check)))
       (draw-in-bounds? in-draw check)))

(defn possible-game? [in-draws check]
  (every? #(possible-draw? % check) in-draws))

(defn sum-ids [input-path check]
  (->>
   (parse-input input-path)
   (map-indexed (fn [i in-draws]
                  [i (possible-game? in-draws check)]))
   (filter #(second %))
   (map first)
   (map inc)
   (reduce +)))

(deftest check-answers
  (is (= (sum-ids example-1 example-1-bag)
         example-1-answer)))


