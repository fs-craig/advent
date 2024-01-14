
(ns advent.2023.14
  (:require [clojure.string :as string]
            [clojure.test :as test :refer :all]))

(def example
  "O....#....
  O.OO#....#
  .....##...
  OO.#O....O
  .O.....O#.
  O.#..O.#.#
  ..O..#O..O
  .......O..
  #....###..
  #OO..#...."
  )

(def t
   "#.###...OO.#.O.O..O#.....#O#..O....#.#OO....O..#.....O##..#....#..#O...OOO#....##...OO#..O....O....O
...O..........#.OO#....O....#..O.#.....##.##O..OOOO#....#OO..O...O#O.O###O..#..O.O..O..OO...OO#.O..O")
(def question
  "#.###...OO.#.O.O..O#.....#O#..O....#.#OO....O..#.....O##..#....#..#O...OOO#....##...OO#..O....O....O
...O..........#.OO#....O....#..O.#.....##.##O..OOOO#....#OO..O...O#O.O###O..#..O.O..O..OO...OO#.O..O
O............O....#....O....OO.#...#O..#.O......OO..#.........#O#..#.#......#..O#...###O...O.....OO.
..#...#..O.#O#..OO#O..#O.....O...#.............OO.O..O...O...O....O....#.#.#O........#...O..OO#..#.#
#.........#..#....O##.O#...O#..O#....O.##O.#.#..#....#..OO..#..##..O.##.O#..O#.....O......O....#O...
...O#O....OO.....#....O#.......O#O..............O....OO..O#.........O#.O.OO..O...O#.O..O...O...#....
..O.O#.....O#....OO#..O.#.#O...#..##.OO.O.O..#O....OO#......#...#...##.#..#O#OO#..O.OO..O.#.#.#...O#
....O.O.OO.#.O#.#.#....O##.....##..#OO....O#O..O.O.O#.O.#.O...#..O..O......#..O.O##.#.#O........#O.#
.O.#O#O.#.O.#..###...O.#.#O#....#O#....O..O.OO...O....##.......OO.......#........#....#..O...O.O....
#O.##.O....#O..O.....#...OO..O#..O..#...#.....O..#.OO.........#O#.O.#O#...O.##.O.....O.........#....
....OO#..O.O#.#.O..........O#........#.#O..O.OO.O..#O....#.O#O#..#.#.....O#...O.#.OOOOOO.#O.##.O...O
..#.OO.O.....#.....#O..##..OO....O#.O.#....##.OOO..#O....O..O.#...O.#...O##O....#..O....OO.#O..O..#.
....#O.O#.....O.....O.....O.O.##...O..O#OOOO..O..OO.O#.O#.O...O.OO.#O...#..O..O..O.#...O#......O.OO.
...O....O.....OO....O..OO#.O#...O....O.##..OOO.#....#OO...#.O...........OOO....OO..........#...#...#
......O.....OO#.##.O....#.O.....O.......O...O......#.O..O#.#..#.O#.#.O.##......#...##.#OO#O.O...##O.
...#O......##..O.OO......O.##OO..O..#.O......O.##.#O....O...........#O..O#.O##.#.O...##....#.OOO.OO.
.O#..OO...O.OO#O...#....O..O#OO....OO##.#.##O###O.##...O.O............OOO....#OOO..#.#..OO.#...#####
O.##O.OO.#......##.O..O...#...OO.....O..#........O....O#O#..O#OO##....O..O..#O.#.........#..O.....#.
.O....#.##...#O.O.OO...O#O#......#..O..#O#OO#.#.#O...#O##O#O.#...#..#...#.O...#.OO..OO....#O.#OO....
....#...#OO....OOO.........O.O....#O....#......O..O.OO.O....#..#..#.#...O.O.OO....O#.......#.OO.O#O#
..#O.#........OO.#...#...#.....#OO.......O.OO#.........##.........##.........#O..#.O#....O##......O.
#O#O.#.O..#O#..O..O...#....#.###..#O.O..O#.#........#....#O.O.OO.#.###O#.#.O#..#O...#......O..O#....
OO..#...............O.OOO...#.......O#.OO......O..O..O.#...OO.##.O........#..O#........##.#.#.O#..##
O...#O.#.....O...##.O..O..#.O..O..O#......OO.OO#OO..O..O...OO#.#....O.O...#.#.#.#O.#..O..O.O#....O.#
O...OO..O...O.O.O.O...#...#.....O.#O...........O...O......O.....#..O...OOO##..#.OO..OO...O.OO.##...#
..O....##O#..#..#..O#.O......##.....##O.....#OO##..OO...........O#......#....#.###.O..OO#.#.......#.
.O..#..O.....##....O...#.OO..#.OO..OOO#O..#..O....##O....OO....O.....#O.O..##O....#....OO..O...#O.O.
..#..#.O#.O...#O..O...#..O.............O#.###.O..O..#..........O.#..#..O#.#..OO....#.........O......
...OO..##O..#O#OO#O...##O#.....O...O.O....#...O..OOO..O..#.....O.O#.O.......O..O.#O...OO.#...O.##...
#O..O#....O..O...O..O....#..........O.O...#.O..O.O.....O...O.#O##.O..O##......#..O......#....O.....O
OO#OOO..O.#...OO.......OO......#.O......OO.O.O#.#....O#OOO#O.#.#O#.O..O..#.....##O.#....O..#.OOO.#.O
.#.O.......O...O...#O....O.OO.#.O#......#OO##.#.##..........O.O#...OO#.OO#..O...#...#.O...O.....#...
.O....OOO#..#..O#......O#..#O.#..#O.O#.O...##O..O..#..O...#O.OO...........O...#O.O.......O..#O......
..#....O...O.....O.O.O...O#.#.....#...#O.O.O#...#...O.O#O....O.OOO#OO...O.#O..O##....O.O.###...OO.OO
..#...#..O#..#OO#..O....O..O.#.O....O#.#......O..O.O###.O#.#.....O.#.##..OO#..O....#.O...#..#..#O...
.....#.O.....#.##...#O........#...O....O......O#...OO#.......OO#...O.#..##O.O...O#..O.#..O....O..##.
#.##.O#.......O.O......OO....O.#.#.O.O....#.O.O...O#..#...O..O##.O.O...#..O#.O..O.O...O..#...O.O.#..
.......O.#.O...#O.O.....O.###..#OO..OO.....OO#O.....O..O.O..##..#........O..#O.#..##..O..O..O..O....
.#...O....O#..O..O........O.O.O........OOO.#....O#...#.O....O...OOOO....O.....#..#.....#...#O.O.#.O.
#O#..O.#O........O#....#...OO#.......O....#O....#.#.....O##...O.O...OO..OO#O#.#....#.O#.......O.OO..
.###..#...#..#...#OOO#..#O...........#...#...O....O#..O#..O..O.#..#.#..O.#...OO.#.........OO.##.O.#.
.OO..#..O.OO.O.#O..O..#O##..O.####..O..OO.#.OO.......O.O#OO....OO#OOO..#.#OO........#..#.#.O.O.O..OO
.O.OO#.O.#..O..#O...#.#..O....##.O#.#O.O........O..#.OO....O...OOO#O.#...O................O.....O.O.
.O......#...O.......O.##.#...O...O..OOO....OO..O....#..O.O.O.O..OO..O......O...O#.##..O.....O.OO...O
..OO...O..O#.O.O.O.O..O.#.##.O..##.O......OO....O..O.O..O.....#..#..............OOO.#...#OO.O..O..##
#.....O...OOO#........#O#.#....#....OOOOO..#.#OOO..O.O#O#O.....#..O.O..............O.O#O..#O.OO#.O..
....O.O..O#..O.....#O#...O.#O.##.O..O.#.#.O.....#O...OOO....O....O......#..O.O.#......O...#O.O...O.#
.O.#.O...O.O#....O..#...O....OO.......O.OO.O##..O#..........OO#.O#O#.O.O...#...O.O......#...........
.#O.....O..#....#O............#..O..OO..O.O.OO.#O.....#....#O.#.....O....O..O..O..#...#...O......#..
....OOO.O......#.O..#O..O..#..O.O...O...#O#.O...O.O......OO...O...#..O#.O..#.#O.#O.#O.##OO..O.......
.O..O...#....O.O...O.OO.OO......OOOO...O#....#.O..#.#..#...O........#..#...###...#..........O....#.#
##.#O...O......O#OO....O.....O..OO.O#.OO...##.OO#..O..OO.......#.#.OO.#....O#O.O.O...#.O##.#.O...#..
..#O#..#.OO.O..#O.O...............#.#O...#....#...#..#..#O...........#......##.......O##..O.#...#..O
O.....#.OO##.O..O..###OO....O...............OO..#.....OOO#.O...#O...#.#..#..##...#O#.OO...O......#..
.##....#.O...O#O..O.##.##.O.#.O...#..#.##...#.......O.OOOOO#....#..O...............O.#O...O##.#....#
#.##.O..#.#...O.....OO#.....O.O.OO.OO#...O..O#.....O...#.......##......#.O.....O#.#O.....O..#.#.....
..#..O...O.O#...#O..O...O.O#.#OO...O...#......O.O.....#.O...O..OO....#...OO..O...#....#O..O.O#.....O
.....O.O.....O.OO#O.O....OO#......#.O.O....#.O..OO.O.......O..O.......###.O....#O..#....O.O##....OO#
#.#.O.##.....O....#.#.O.....O..O.O...##O#.O.#O.....#.#........O..O#...#......O#.#O#...#O........O.#.
..O..#..........#..O.O.#..OO.O.O..O..O.OO.#O..#.O..OO..OO.O#..O#OO#O.#.#.O...O.............O....O..O
.#...#O.#........O#..#.....O.##...#..O#..O..O..O.....O#.....OO..##..O..##O.#....O..#O.##.....O..OO..
....#..O.#..#.O...#.....O.O.O.......#.O..O..........O.#O.#.O#..#.....O.#.....O..#O...OO...O..#......
O...#...O........O.O.#O##O.....O....#...O....#....##...#.O.OO.....O.O##.OO#.#.O.OO.O.#O..O......O...
..OO.....O...O.O...O..#..O##OO...#..#.........#O.O#O.......O#OO.O..O..O..O.##O#O.#O..OOO..#.O.O.O.#.
O..O##...OO..#.#..O.#.O.O...#..O.....#....O#..O.O..O..OO.OO.........O..#.#.#...##..#.....O....O.#O..
.#.#......O....O#..O.##.#O.O..OO...#O#O.#..OO.O#....O.##O#....O......#...#O....O..........O.#O....O.
###...O....O...OO....O...O.O....#..#...#.O....O......O.O....#..##...O.#........OO.....#.O....O......
...#.#.O..O#...#.O#.O#.#O#...OO.O#.#O...#O.......O#.#O..#..##.##O##.....##.O.....O...#....#.....##..
OO.O..#.O...#....O#...#.##.#....OO..#..#..O....O#...O#..#..OO...#O.#....##O....#O.O....O.#..#.....O#
.#.O.O..O..#...O...O......O#O....##....O......#......O..#.#...........OOO.#.....O.#.#.............O.
O.....O...#OO.OOO..#....#....#O....O.O..........O...O...#.OO..O.O.##...O.OOOO..O...O....O..O.#......
#O........O..#O#.O..O#.......#OO.....#....#O##.O.O#.O.#O.O....O.O#O....O.O.OO....#.......O...#O..O..
#...O.#.#...#.O.O.#....O.OO...O..O....#...........O....#.OO.OO#.#OO.....OO..O.##....O..#O.....#O..#.
##..#.OO.#OO..OO..##.........O....#...OOO..##O#..O.O.#.##O.#.##O.O...O..#O.O..O.O......#.#OO...O#O..
.O....O#...O.....O#..O...#....O....O#......O..#.#O........#.O#..#..O.#.##..#..........#........O.#.O
.OO#.O.O.###.........O.O..#...#.O..O...OO..#.OO....#..#.........O#.....OO..O......#.......O....O.O#.
OO.OO.O.#.OO..#O..O.......##....O.O.#.##..##..#..O..O#...O...#...#...O.OOO.#O..O...#.O.O....OO......
#.#..O.O.......OO.#.#..O..OO#O.....O#.#......O....O..O##.O.O##..O#.........#OO..O....#.#....O.O..O..
#......#.O.#.....OO...#O.....#.O.........O.#..##O..OOO.##O....O...##...#..O#.O..#...O.OO...OO#....##
O......OO#..O#.#.#...OO.#O....#O#.O#..#..OO...#..#..O.#....#.O.#O.##O...#.....O....OO..........O.##.
.O...O..#O.OO...OOO.#..#..#.#..OO.O......#O#..O.........#........O.OO.O.###....#O#.#.#.#O..OOO....O.
O.....#O#....#....OO..OO...O.....##O.O#.##.O.#......O.#...O#.#O.OO##.........O#...#O##.O...#..O.#..#
.#.##...#O.#O..O#..#.#.#...#...O.O.O#..#.O..O.O#.#......OOO....#.O.O..O.O##..OOO..OO......O....OO#O.
O..##......O...O...O#OO#.......O..O..#....#.#..O....O..OO..O##O#O..#..O...O.O.O..##...#...###.....O.
.O..O...O...#...O...##...O#....O.....O.O.O#..#.....#....O..#.#...OO...OO.O..O..O##....O#O.#O..#....O
.#..O..O..#.#.O.O.#..#.O.#.#.#.#..O..O..O..O...#O....##..#.#.O...OO..#O....#..#.#..O.....O.O.....O.#
#...OO.#.....#.OOO#....O..O...O#O..#.OO..O.O.#...........O.....O.OO.#OO.O##O.......O....O...........
...#.......##.O..#O..O#.#O.....O.#.O.....#O#.#.......#....OO#.....#.#..O.OO#O..O...#..#.O#.#OOO..O..
.#.O............#OO.##O.O.O..#...O....O#O....O....OO..O..O.OO.#...OO#.#..##.OO..##..O.##..#...O.#O..
O#O...#...O#.#..OO.....O.OO..O#...O..#O#OO#..#O##..O.....#.O.#.O.OOOO...O..#.#..O..O...#O..#O#.O....
.O..##.#..O.O.O...O...O.O..#..O.#.O.O.O#.#.O...O.#.#.O##.#.O.O.##...O...O.O...#O#OOOO#...#.OO....#O.
O..O.O....O.O....O.O.O.O.......O.O...O..#O#.OOO#............#.........O..O#.OO#..O#..#.#....#.#.....
.##.O...O..........OO...#O..#.......#..#..##.#.O..O.OO.#..#...O..O#.#.#O..#.OOO#..O..O.OO.#..#..#...
..O.......O#.O...OO.....O.OO..OO#.........#...O#.#.O......O.#...#...........OO..O....##....#.O...O..
...#..O..#....#....##O...O.O....#....#O.....##.#.....OOOO..##.O##........#.O..O.....O...#....O....#O
...O#O...O....O...O...O..#......#..OO..O...#..#...#O......O.O..O.O.O...O..O..#...##.O#.O..O###..OOO#
...O.O.#OOOO.OO...O.......##.#O.#.O...#.....#..O........#.#.O#.#O#...O##.......O..O.....##..O....#.O
..O.O#.O.OO..#...O....O....O...#O..##.....OO.#.#.#.OO.#..OO.......O....##..O#.O.O.......#O#O#O..OO.#
OO#......OO.......O..O..#.OOOO#O......#.###.#O...#O#O...#..O..O....O#.#...#O.###O.#.OO....OO....#...
#.#.O..#....##....#..#................O.......#O.#O#O...##O.OO...O...#...O.##....O.O......##.O..#..O")

;;split on #
;;;;for each n-column in (range first row)
;;count the newlines for the load calculation
;;get the row vectors
;;compute load(map n-column onto the row vectors)

;;split by #
;;reduce or loop last-rock current-load
;;count the 0s to add to current-load with take range(6 4 -1)
;;count total items to add to last-rock

(defn roll-rocks [next-section num-rollers]  
  (concat (repeat num-rollers "O")
  (repeat (count
           (re-seq #"\." next-section)) ".")))
  
(defn load-between [{:keys [last-rock current-load
                            rocks-after] :as acc}
                    next-section]
  (let [num-rollers (count (re-seq #"O" next-section))
        loads (range last-rock (- last-rock num-rollers) -1)
        new-last (dec (- last-rock (count next-section)))
        final-boulder (if (= new-last -1) "" "#")]
    {:last-rock new-last
     :current-load (+ current-load (reduce + loads))
     :rocks-after (concat rocks-after
                          (roll-rocks next-section num-rollers)
                          final-boulder)}))

(defn remove-tail [{:keys [rocks-after] :as status}]
  (assoc status :rocks-after (butlast rocks-after)))

(defn split-boulders-str [column-str]
  (string/split column-str #"#" -1))

(defn split-boulders [column]
  (->> 
   (partition-by #(= % \#))
   (remove #(= (first %) \#))))

(defn compute-load [column-rocks max-load]
  (let [splits (split-boulders-str column-rocks)]
    (reduce load-between {:last-rock max-load
                          :current-load 0
                          :rocks-after []}
            splits)))

(defn get-max-load [columns]
  (count (first columns)))

(defn indexes-of [e coll] (keep-indexed #(if (= e %2) %1) coll))

(defn index->load [column max-load]
  (->> column
       (map (fn [index] (- max-load index)))
       (reduce +)))

(defn north-load [columns]
  (let [max-load (get-max-load columns)]
    (->>
     (map #(indexes-of \O %) columns)
     (map #(index->load % max-load))
     (reduce +))))
    
(defn columns<->rows [items reverse?]
  (let [new-count (count (first items))
        order (if reverse?
                (range (dec new-count) -1 -1)
                (range new-count))]
    (for [i order]
      (->> (map #(nth % i) items)
           (reduce str)))))

(defn get-cols [rocks]
  (let [rows (string/split
              (string/replace rocks #" " "") #"\n")]
    (columns<->rows rows false)))

(defn roll-rocks-north [columns]
  (let [max-load (get-max-load columns)]
  (->> columns
       (map #(compute-load % max-load)))))

(defn rotate-clockwise [columns]
  (columns<->rows columns true))
       
(defn roll-and-rotate [columns]
  (->> ;;returns the new columns after rotating
   (roll-rocks-north columns)
   (map :rocks-after)
   (rotate-clockwise)))

(defn one-cycle [columns]
  (nth (iterate roll-and-rotate columns)
       4))

(defn cycles [columns n]
  (rest (iterate one-cycle columns)))

(defn north-beams-load [status-maps]
  (->> status-maps
       (map :current-load)
       (reduce +)))
       
(defn rolled-north-load [rocks]
  (->> (get-cols rocks)
       (roll-rocks-north)
       (north-beams-load)))

(defn cycle-loads [num-cycles rocks]
  (-> (get-cols rocks)
      (cycles num-cycles)
      (#(map north-load %))
      (#(take num-cycles %))))

(def given-cycles 1000000000)

;;after 1 cycle, etc.
(def example-root [87 69])
(def example-repeats [69 69 65 64 65 63 68])

;;4 root
;;repeat 2
;;given-cycles 7
;;(rem (- 7 4) 2)
;;need 3rd element
;;broken into 2s
;;need to dec for the nth element
;;[1 2 3 4 5 6 5]
(defn element-after [root repeats n]
  (->> root
       count
       (- n)
       (#(rem % (count repeats)))
       dec
       (nth repeats)))
  
(deftest examples
  (is (= (rolled-north-load question) 112046) "part 1")
  (is (= (element-after example-root example-repeats given-cycles))
      "part 2 example"))


