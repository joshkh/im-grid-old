(ns im-grid.views.table.body)

(defn cell []
  (fn [c]
    [:td.im-grid-cell (:value c)]))

(defn row []
  (fn [r]
    (into [:tr.im-grid-row] (map (fn [c] [cell c]) r))))

(defn main []
  (fn [results]
    (into [:tbody.im-grid-body] (map (fn [r] [row r]) results))))