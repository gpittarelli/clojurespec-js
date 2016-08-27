rm dist/*
lein do clean, cljsbuild once
sed -e '/CLOSURE_OUTPUT/ {
  r dist/clojurespec.js
  d
}' resources/universal-module.js > dist/clojurespec.js.tmp
mv dist/clojurespec.js.tmp dist/clojurespec.js
