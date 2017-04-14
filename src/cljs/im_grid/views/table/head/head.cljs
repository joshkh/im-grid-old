(ns im-grid.views.table.head.head
  (:require [clojure.string :refer [split join]]))

(defn add-chevrons [string]
  (vec (into [:span.column-label] (interpose [:i.fa.fa-angle-right.fa-fw] (map (fn [s] [:span s]) (split string " > "))))))

(defn header [db-path]
  (fn [db-path h]
    (println "s" (add-chevrons (:display-name h)))
    [:div.im-grid-column-header (add-chevrons (:display-name h))]))

(defn main [db-path]
  (fn [db-path headers]
    [:div.im-grid-head
     (into [:div.im-grid-row] (map (fn [h] [header db-path h]) headers))]))