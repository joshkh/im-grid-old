(ns im-grid.subs.table
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :as re-frame :refer [reg-sub]]))



(reg-sub
  ::results
  (fn [db [_ db-path]]
    (get-in db (concat db-path [:response :results]))))

(reg-sub
  ::column-headers
  (fn [db [_ db-path]]
    (map (fn [view display-name]
           {:view view
            :display-name display-name})
         (get-in db (concat db-path [:response :views]))
         (get-in db (concat db-path [:response :columnHeaders])))))

