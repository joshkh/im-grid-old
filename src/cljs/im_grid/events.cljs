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
  (fn [db [_ db-path {:keys [columnHeaders iTotalRecords start results] :as response}]]
    (let [size (count results)]
      (.log js/console size response)
      (update-in db db-path assoc :response response))))

(reg-event-fx
  ::load-page-1
  (fn [{db :db} [_ db-path query]]
    {:im-grid.effects/imcljs {:on-success [::store-load-results db-path]
                              :request (fetch/table-rows
                                         global-service
                                         global-query
                                         {:size 10 :start 0})}}))

(reg-event-fx
  ::load-page-3
  (fn [{db :db} [_ db-path query]]
    {:im-grid.effects/imcljs {:on-success [::store-load-results db-path]
                              :request (fetch/table-rows
                                         global-service
                                         global-query
                                         {:size 10 :start 10})}}))