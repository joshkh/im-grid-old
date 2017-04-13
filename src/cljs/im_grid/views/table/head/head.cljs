(ns im-grid.views.table.head)

(defn cell []
  (fn [c]
    [:td (:value c)]))

(defn header []
  (fn [h]
    [:th (:display-name h)]))

(defn main []
  (fn [headers]
    [:thead
     (into [:tr] (map (fn [h] [header h]) headers))]))