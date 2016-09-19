(ns clojurespec
  (:require [cljs.spec :as s]))

(def ^{:export invalid} invalid (js/Symbol "invalid"))

(defn- coalesce-invalid [x]
  (if (= :cljs.spec/invalid x) invalid x))

(def spec-methods
  [["form" s/form]
   ["&" s/&]
   ["*recursion-limit*" s/*recursion-limit*]
   ["*coll-error-limit*" s/*coll-error-limit*]
   ["fspec" s/fspec]
   ["explain-printer" s/explain-printer]
   ["Specize" s/Specize]
   ["every" s/every]
   ["keys*" s/keys*]
   ["alt-impl" s/alt-impl]
   ["def-impl" s/def-impl]
   ["*explain-out*" s/*explain-out*]
   ["regex-spec-impl" s/regex-spec-impl]
   ["merge-spec-impl" s/merge-spec-impl]
   ["explain-data*" s/explain-data*]
   ["check-asserts" s/check-asserts]
   ["assert*" s/assert*]
   ["inst-in-range?" s/inst-in-range?]
   ["nilable" s/nilable]
   ["and-spec-impl" s/and-spec-impl]
   ["describe*" s/describe*]
   ["map-spec-impl" s/map-spec-impl]
   ["coll-of" s/coll-of]
   ["cat" s/cat]
   ["*" s/*]
   ["explain" s/explain]
   ["map-spec" s/map-spec]
   ["with-gen*" s/with-gen*]
   ["or-spec-impl" s/or-spec-impl]
   ["*fspec-iterations*" s/*fspec-iterations*]
   ["Spec" s/Spec]
   ["unform" s/unform]
   ["valid?" s/valid?]
   ["gen" s/gen]
   ["every-kv" s/every-kv]
   ["int-in" s/int-in]
   ["alt" s/alt]
   ["nonconforming" s/nonconforming]
   ["unform*" s/unform*]
   ["abbrev" s/abbrev]
   ["regex?" s/regex?]
   ["int-in-range?" s/int-in-range?]
   ["or" s/or]
   ["spec?" s/spec?]
   ["registry" s/registry]
   ["rep+impl" s/rep+impl]
   ["exercise-fn" s/exercise-fn]
   ["exercise" s/exercise]
   ["multi-spec" s/multi-spec]
   ["explain-data" s/explain-data]
   ["tuple-impl" s/tuple-impl]
   ["multi-spec-impl" s/multi-spec-impl]
   ["tuple" s/tuple]
   ["conform" s/conform]
   ["gen*" s/gen*]
   ["fspec-impl" s/fspec-impl]
   ["assert" s/assert]
   ["?" s/?]
   ["*coll-check-limit*" s/*coll-check-limit*]
   ["merge" s/merge]
   ["get-spec" s/get-spec]
   ["conformer" s/conformer]
   ["every-impl" s/every-impl]
   ["spec" s/spec]
   ["keys" s/keys]
   ["spec-impl" s/spec-impl]
   ["+" s/+]
   ["invalid?" s/invalid?]
   ["amp-impl" s/amp-impl]
   ["map-of" s/map-of]
   ["cat-impl" s/cat-impl]
   ["explain-str" s/explain-str]
   ["*compile-asserts*" s/*compile-asserts*]
   ["with-gen" s/with-gen]
   ["conform*" s/conform*]
   ["check-asserts?" s/check-asserts?]
   ["rep-impl" s/rep-impl]
   ["double-in" s/double-in]
   ["inst-in" s/inst-in]
   ["describe" s/describe]
   ["explain-out" s/explain-out]
   ["and" s/and]
   ["specize*" s/specize*]
   ["def" s/def]
   ["maybe-impl" s/maybe-impl]
   ["explain*" s/explain*]
   ["fdef" s/fdef]])

(doseq [[name method] spec-methods]
  (goog/exportSymbol name (comp coalesce-invalid method)))
