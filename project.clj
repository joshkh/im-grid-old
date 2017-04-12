(defproject im-grid "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0-alpha13"]
                 [org.clojure/clojurescript "1.9.229"]
                 [reagent "0.6.0" :exclusions [cljsjs/react]]
                 [cljsjs/react-with-addons "15.4.2-2"]
                 [cljsjs/react-dom "15.4.2-2" :exclusions [cljsjs/react]]
                 [baking-soda "0.1.2"]
                 [re-frame "0.9.2"]
                 [compojure "1.5.0"]
                 [yogthos/config "0.8"]
                 [day8.re-frame/async-flow-fx "0.0.6"]
                 [day8.re-frame/undo "0.3.2"]
                 [binaryage/oops "0.5.2"]
                 [org.clojure/core.async "0.2.395"]
                 [intermine/imcljs "0.1.14-SNAPSHOT"]]

  :plugins [[lein-cljsbuild "1.1.4"]
            [lein-less "1.7.5"]]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"
                                    "test/js"]

  :figwheel {:css-dirs ["resources/public/css"]}

  :less {:source-paths ["less"]
         :target-path  "resources/public/css"}

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "0.8.2"]]

    :plugins      [[lein-figwheel "0.5.9"]
                   [lein-doo "0.1.7"]]
    }}

  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src/cljs"]
     :figwheel     {:on-jsload "im-grid.core/mount-root"}
     :compiler     {:main                 im-grid.core
                    :output-to            "resources/public/js/compiled/app.js"
                    :output-dir           "resources/public/js/compiled/out"
                    :asset-path           "js/compiled/out"
                    :source-map-timestamp true
                    :preloads             [devtools.preload]
                    :external-config      {:devtools/config {:features-to-install :all}}
                    }}

    {:id           "min"
     :source-paths ["src/cljs"]
     :compiler     {:main            im-grid.core
                    :output-to       "resources/public/js/compiled/app.js"
                    :optimizations   :advanced
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    false}}

    {:id           "test"
     :source-paths ["src/cljs" "test/cljs"]
     :compiler     {:main          im-grid.runner
                    :output-to     "resources/public/js/compiled/test.js"
                    :output-dir    "resources/public/js/compiled/test/out"
                    :optimizations :none}}
    ]}

  )
