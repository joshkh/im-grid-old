(ns im-grid.effects
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [re-frame.core :refer [reg-fx dispatch]]
            [cljs.core.async :refer [<!]]))

(reg-fx
  ::imcljs
  (fn [{:keys [on-success on-failure response-format request params]}]
    (go
      (let [{:keys [statusCode] :as response} (<! request)]
        (if (and statusCode (>= statusCode 400))
          (dispatch [:flag-invalid-tokens])
          (dispatch (conj on-success response)))))))