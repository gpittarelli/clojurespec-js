(ns clojurespec
  (:require [cljs.spec :as s]))

(def ^{:export invalid} invalid (js/Symbol "invalid"))

(defn- coalesce-invalid [x]
  (if (= :cljs.spec/invalid x) invalid x))

;;(def spec-macros
;;  [["&" s/&]
;;   ["fspec" s/fspec]
;;   ["explain-printer" s/explain-printer]
;;   ["Specize" s/Specize]
;;   ["every" s/every]
;;   ["keys*" s/keys*]
;;   ["nilable" s/nilable]
;;   ["*explain-out*" s/*explain-out*]
;;   ["nilable" s/nilable]
;;   ["coll-of" s/coll-of]
;;   ["cat" s/cat]
;;   ["*" s/*]
;;   ["every-kv" s/every-kv]
;;   ["int-in" s/int-in]
;;   ["alt" s/alt]
;;   ["nonconforming" s/nonconforming]
;;   ["or" s/or]
;;   ["exercise-fn" s/exercise-fn]
;;   ["multi-spec" s/multi-spec]
;;   ["tuple" s/tuple]
;;   ["assert" s/assert]
;;   ["?" s/?]
;;   ["merge" s/merge]
;;   ["conformer" s/conformer]
;;   ["spec" s/spec]
;;   ["keys" s/keys]
;;   ["+" s/+]
;;   ["double-in" s/double-in]
;;   ["inst-in" s/inst-in]
;;   ["and" s/and]
;;   ["invalid?" s/invalid?]
;;   ["map-of" s/map-of]
;;   ["specize*" s/specize*]
;;   ["def" s/def]
;;   ["fdef" s/fdef]])

(defn ^{:export "and"} exported-and [& forms]
  (s/and-spec-impl '~[forms] forms nil))

(defn ^{:export "or"} exported-or [& key-pred-forms]
  (let [pairs (partition 2 key-pred-forms)
        keys (mapv first pairs)
        pred-forms (mapv second pairs)
        pf pred-forms]
    (assert (and (even? (count key-pred-forms))
                 (every? keyword? keys))
            "spec/or expects k1 p1 k2 p2..., where ks are keywords")
    (s/or-spec-impl keys pf pred-forms nil)))

(def spec-methods
  [["form" s/form true]
   ["*recursion-limit*" s/*recursion-limit*]
   ["*coll-error-limit*" s/*coll-error-limit*]
   ["alt-impl" s/alt-impl]
   ["def-impl" s/def-impl]
   ["regex-spec-impl" s/regex-spec-impl]
   ["merge-spec-impl" s/merge-spec-impl]
   ["explain-data*" s/explain-data*]
   ["check-asserts" s/check-asserts]
   ["assert*" s/assert*]
   ["inst-in-range?" s/inst-in-range?]
   ["and-spec-impl" s/and-spec-impl]
   ["describe*" s/describe*]
   ["map-spec-impl" s/map-spec-impl]
   ["explain" s/explain]
   ["map-spec" s/map-spec]
   ["with-gen*" s/with-gen*]
   ["or-spec-impl" s/or-spec-impl]
   ["*fspec-iterations*" s/*fspec-iterations*]
   ["Spec" s/Spec]
   ["unform" s/unform]
   ["valid?" s/valid?]
   ["gen" s/gen]
   ["unform*" s/unform*]
   ["abbrev" s/abbrev]
   ["regex?" s/regex?]
   ["int-in-range?" s/int-in-range?]
   ["spec?" s/spec?]
   ["registry" s/registry]
   ["rep+impl" s/rep+impl]
   ["exercise" s/exercise]
   ["explain-data" s/explain-data]
   ["tuple-impl" s/tuple-impl]
   ["multi-spec-impl" s/multi-spec-impl]
   ["conform" s/conform true]
   ["gen*" s/gen*]
   ["fspec-impl" s/fspec-impl]
   ["*coll-check-limit*" s/*coll-check-limit*]
   ["get-spec" s/get-spec]
   ["every-impl" s/every-impl]
   ["spec-impl" s/spec-impl]
   ["amp-impl" s/amp-impl]
   ["cat-impl" s/cat-impl]
   ["explain-str" s/explain-str]
   ["*compile-asserts*" s/*compile-asserts*]
   ["with-gen" s/with-gen]
   ["conform*" s/conform*]
   ["check-asserts?" s/check-asserts?]
   ["rep-impl" s/rep-impl]
   ["describe" s/describe]
   ["explain-out" s/explain-out]
   ["maybe-impl" s/maybe-impl]
   ["explain*" s/explain*]])

(doseq [[name method convert?] spec-methods]
  (->> method
       (comp (if convert? clj->js identity) coalesce-invalid)
       (goog/exportSymbol name)))
