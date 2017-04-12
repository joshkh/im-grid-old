(ns im-grid.views
  (:require [re-frame.core :as re-frame :refer [dispatch]]))



(defn main []
  (let [db (re-frame/subscribe [:im-grid.subs/db])]
    (fn [db-id data-sub]
      [:div.alert.alert-success
       [:button.btn
        {:on-click (fn [] (dispatch [:im-grid.events/load]))}
        "test"]
       [:label "Hello from " (str @db)]])))
