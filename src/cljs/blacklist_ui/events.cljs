(ns blacklist-ui.events
  (:require [ajax.core :as ajax]
            [re-frame.core :as re-frame]
            [blacklist-ui.db :as db]
            [day8.re-frame.tracing :refer-macros [fn-traced defn-traced]]))

(re-frame/reg-event-db
 ::initialize-db
 (fn-traced [_ _]
   db/default-db))

(re-frame/reg-event-db
 ::set-active-panel
 (fn-traced [db [_ active-panel]]
   (assoc db :active-panel active-panel)))

(re-frame/reg-event-fx
  :fetch-blacklist
  (fn [{db :db} _]
    {:http-xhrio {:method          :get
                  :uri             "/blacklist/entries"
                  :format          (ajax/transit-request-format)
                  :response-format (ajax/transit-response-format)
                  :on-success      [:process-blacklist-response]
                  :on-failure      [:http-error]}
     :db         (assoc db :blacklist-loaded? false)}))

(re-frame/reg-event-db
  :process-blacklist-response
  (fn
    [db [_ response]]
    (-> db
        (assoc :blacklist-loaded? true)
        (assoc :blacklist (js->clj response)))))