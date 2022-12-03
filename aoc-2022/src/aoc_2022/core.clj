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

(defn sum-of-coll [coll]
  (map #(sum (read-numbers (str/split-lines %)))
       coll))

(defn solve-aoc-1 []
  (apply max (sum-of-coll day-one-input)))

(defn solve-aoc-1-2 []
  (sum (take 3 (sort > (sum-of-coll day-one-input)))))

;; Day 2


