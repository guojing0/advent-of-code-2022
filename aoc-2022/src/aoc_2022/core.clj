(ns aoc-2022.core
  (:require [clojure.string :as str]
            [clojure.java.io :as io])
  (:gen-class))

;;; Helper functions

(defn read-file [file]
  (slurp (io/resource file)))

(defn read-lines [file]
  (str/split-lines (read-file file)))

(defn read-numbers [lst]
  (map read-string lst))

(defn sum [lst]
  (reduce + lst))

;;; Day 1

(def day-one-input (str/split (read-file "day1.txt") #"\n\n"))

(defn solve-aoc-1 []
  (apply max
         (map #(sum (read-numbers (str/split-lines %)))
              day-one-input)))

(defn solve-aoc-1-2 []
  (sum (take 3
             (sort >
                   (map #(sum (read-numbers (str/split-lines %)))
                        day-one-input)))))
