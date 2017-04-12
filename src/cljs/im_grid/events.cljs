(ns im-grid.events
  (:require [re-frame.core :as re-frame :refer [reg-event-fx reg-event-db]]
            [im-grid.db :as db]
            [imcljs.fetch :as fetch]))

(def global-service {:root "beta.flymine.org/beta"
                     :model {:name "genomic"}})

(def global-query {:from "Gene"
                   :select ["name" "symbol"]
                   :where [{:path "symbol" :op "=" :value "a*"}]})

(re-frame/reg-event-db
  :initialize-db
  (fn [_ _]
    db/default-db))

(reg-event-db
  ::store-load-results
  (fn [db [_ {:keys [columnHeaders iTotalRecords start results]}]]
    (let [size (count results)])
    db))

(reg-event-fx
  ::load
  (fn [{db :db} [_ query]]
    {:im-grid.effects/imcljs {:on-success [::store-load-results]
                              :request (fetch/table-rows
                                         global-service
                                         global-query
                                         {:size 1
                                          :start 1})}}))