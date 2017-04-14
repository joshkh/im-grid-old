(ns im-grid.views.table.table
  (:require [re-frame.core :refer [subscribe]]
            [im-grid.views.table.head.head :as head]
            [im-grid.views.table.body.body :as body]))

(defn main [db-path]
  (let [results (subscribe [:im-grid.subs.table/results db-path])
        column-headers (subscribe [:im-grid.subs.table/column-headers db-path])]
    (fn [db-id]
      [:div
       [head/main db-path @column-headers]
       [body/main db-path @results]])))