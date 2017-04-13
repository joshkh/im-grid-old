(ns im-grid.views.table
  (:require [re-frame.core :refer [subscribe]]
            [im-grid.views.table.head :as head]
            [im-grid.views.table.body :as body]))

(defn main []
  (let [results (subscribe [:im-grid.subs.table/results])
        column-headers (subscribe [:im-grid.subs.table/column-headers])]
    (fn []
      [:table.table.im-grid
       [head/main @column-headers]
       [body/main @results]])))