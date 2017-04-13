(ns im-grid.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :as re-frame]
            [im-grid.subs.table]))

(re-frame/reg-sub
  :name
  (fn [db]
    (:name db)))

(re-frame/reg-sub ::db (fn [db] db))



