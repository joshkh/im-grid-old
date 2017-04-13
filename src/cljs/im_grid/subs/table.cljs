(ns im-grid.subs.table
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :as re-frame :refer [reg-sub]]))

(reg-sub
  ::results
  (fn [db]
    (get-in db [:response :results])))

(reg-sub
  ::column-headers
  (fn [db]
    (map (fn [view display-name]
           {:view view
            :display-name display-name})
         (get-in db [:response :views])
         (get-in db [:response :columnHeaders]))))

