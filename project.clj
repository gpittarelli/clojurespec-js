(defproject clojurespec-js "0.0.0"
  :description "clojure spec wrapper for JavaScript"

  :source-paths ["src"]

  :dependencies
  [[org.clojure/clojure "1.9.0-alpha12"]
   [org.clojure/clojurescript "1.9.227"]
   [org.clojure/test.check "0.9.0"]]

  :plugins
  [[lein-cljsbuild "1.1.4"]]

  :cljsbuild
  {:builds
   [{:source-paths ["src"]
     :id "release"
     :compiler
     {:output-to "dist/clojurespec.js"
      :output-dir "dist"
      :source-map "dist/clojurespec.js.map"
      :optimizations :advanced
      :warnings {:single-segment-namespace false}
      :output-wrapper false
      :pretty-print false}}]})
