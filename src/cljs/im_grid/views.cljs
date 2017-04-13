(ns im-grid.views
  (:require [re-frame.core :as re-frame :refer [dispatch]]
            [im-grid.views.table :as table]))


(def original '(1 2 3))
(def more '(7 8 9))
(def middle '(4 5 6))

(def funky '(1 2))

(defn padded-take [n coll]
  (take n (concat coll (repeat nil))))

(defn splice
  [index old-col new-col]
  (concat (concat (padded-take index old-col) new-col) (drop (+ index (count new-col)) old-col)))

(defn main []
  (let [db (re-frame/subscribe [:im-grid.subs/db])]
    (fn [db-id data-sub]
      [:div
       [:button.btn
        {:on-click (fn [] (dispatch [:im-grid.events/load-page-1]))}
        "Load Page 1"]
       [:button.btn
        {:on-click (fn [] (dispatch [:im-grid.events/load-page-3]))}
        "Load Page 3"]

       [table/main]])))
