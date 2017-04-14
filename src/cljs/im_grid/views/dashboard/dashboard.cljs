(ns im-grid.views.dashboard.dashboard
  (:require [re-frame.core :as re-frame :refer [dispatch]]
            [im-grid.views.table.table :as table]))


(defn main [db-path]
  (fn [db-path]
    [:div.dashboard
     [:div.btn-toolbar
      [:button.btn.btn-primary
       {:on-click (fn [] (dispatch [:im-grid.events/load-page-1 db-path]))}
       "Load Page 1"]
      [:button.btn
       {:on-click (fn [] (dispatch [:im-grid.events/load-page-3 db-path]))}
       "Load Page 3"]]]))