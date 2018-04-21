(ns blacklist-ui.subs
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::name
 (fn [db]
   (:name db)))

(re-frame/reg-sub
 ::active-panel
 (fn [db _]
   (:active-panel db)))

(re-frame/reg-sub
  :blacklist
  (fn [db _]
    (:blacklist db)))

(re-frame/reg-sub
  :blacklist-loaded?
  (fn [db _]
    (:blacklist-loaded? db)))

