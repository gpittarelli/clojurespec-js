(ns clojurespec
  (:require [cljs.spec :as s]))

(defn ^{:export hello} hello
  [x]
  (str "Hello " x))
