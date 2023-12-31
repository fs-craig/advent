
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




;;for each column in (range first row)
;;move rocks north
;;keep track of already-covered and
;;left-to-cover
;;while something in left-to-cover
;;try-swap already-covered to left-to-cover
;;initiate already-covered to first item
;;case 0. change nothing
;;case .0 swap
;;case 00 change nothing
;;case .. change nothing

;;noooo
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
        loads (range last-rock (- last-rock num-rollers) -1)]
    {:last-rock (dec (- last-rock (count next-section)))
     :current-load (+ current-load (reduce + loads))
     :rocks-after (concat rocks-after
                          (roll-rocks next-section num-rollers)
                          "#")}))

(defn remove-tail [{:keys [rocks-after] :as status}]
  (assoc status :rocks-after (butlast rocks-after)))

(defn compute-load [column-rocks max-load]
  (let [splits (string/split column-rocks #"#" -1)]
    (reduce load-between {:last-rock max-load
                          :current-load 0
                          :rocks-after []}
            splits)))

(defn get-max-load [columns]
  (count (first columns)))

(defn columns<->rows [items]
  (let [new-count (count (first items))]
    (for [i (range new-count)]
      (->> (map #(nth % i) items)
           (reduce str)))))

(defn get-cols [rocks]
  (let [rows (string/split
              (string/replace rocks #" " "") #"\n")]
    (columns<->rows rows)))

(defn roll-rocks-north [columns]
  (let [max-load (get-max-load columns)]
  (->> columns
       (map #(compute-load % max-load))
       (map remove-tail))))

;;TODO:
;;Write columns<->rows.
;;write cycle based on rotation rocks-after.
;;rewrite column-total for rock columns and add a test, so
;;total-load needs to be rewritten to parse rocks then send to
;;column-total.

(defn rotate-clockwise [columns]
  (reverse (columns<->rows columns)))

(defn rotate-and-roll [columns]
  (->> ;;returns the new columns after rotating
   (rotate-clockwise columns)
   (roll-rocks-north)
   (map :rocks-after)))

;;finished here on dec 30
;;change above to roll-and-rotate
;;then one cycle is 4 of those with a reduce
;;then i should be close.
(defn one-cycle [])

(defn north-beams-load [status-maps]
  (->> status-maps
       (map :current-load)
       (reduce +)))
       
(defn rolled-north-load [rocks]
  (->> (get-cols rocks)
       (roll-rocks-north)
       (north-beams-load)))

(defn load-after-cycles [num-cycles])

(deftest examples
  (is (= (rolled-north-load question) 112046)))
