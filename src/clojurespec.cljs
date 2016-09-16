(ns clojurespec
  (:require [cljs.spec :as s]))

(def ^{:export invalid} invalid (js/Symbol "invalid"))

(defn- coalesce-invalid [x]
  (if (= :cljs.spec/invalid x) invalid x))

(doseq [[name method] [["conform" s/conform]]]
  (goog/exportSymbol name (comp coalesce-invalid method)))
