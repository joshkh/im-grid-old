(ns im-grid.views.table.body.body)

(defn cell [db-path]
  (fn [db-path c]
    [:div.im-grid-cell (:value c)]))

(defn row [db-path]
  (fn [db-path r]
    (into [:div.im-grid-row] (map (fn [c] [cell db-path c]) r))))

(defn main [db-path]
  (fn [db-path results]
    (into [:div.im-grid-body] (map (fn [r] [row db-path r]) results))))