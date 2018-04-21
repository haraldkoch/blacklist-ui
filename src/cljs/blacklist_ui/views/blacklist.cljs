(ns blacklist-ui.views.blacklist
  (:require [re-frame.core :as re-frame]))

(defn blacklist-panel []
  [:div (str "This is the blacklist editing panel.")
   [:div [:a {:href "#/about"} "go to About Page"]]
   [:div [:a {:href "#/"} "go to Home Page"]]])

