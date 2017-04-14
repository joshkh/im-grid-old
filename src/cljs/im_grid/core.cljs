(ns im-grid.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [im-grid.events]
              [im-grid.subs]
              [im-grid.effects]
              [im-grid.views :as views]
              [im-grid.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main [:grids :grid1]]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup)
  (mount-root))
