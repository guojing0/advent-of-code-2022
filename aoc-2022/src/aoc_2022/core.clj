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

(defn solve-aoc-1 []
  (let [result (str/split (read-file "day1.txt") #"\n\n")]
    (apply max
           (map #(sum (read-numbers (str/split-lines %)))
                result))))
