(ns im-grid.views
  (:require [re-frame.core :as re-frame :refer [subscribe dispatch]]
            [im-grid.views.dashboard.dashboard :as dashboard]
            [im-grid.views.table.table :as table]))




(defn padded-take [n coll]
  (take n (concat coll (repeat nil))))

(defn splice
  [index old-col new-col]
  (concat (concat (padded-take index old-col) new-col) (drop (+ index (count new-col)) old-col)))

(defn main [db-path]
  (let [db (subscribe [:im-grid.subs/db])]
    (fn [db-path]
     (.log js/console "db" @db)
      [:div.im-grid
      [dashboard/main db-path]
      [table/main db-path]])))

