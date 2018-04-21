(ns blacklist-ui.views
  (:require [re-frame.core :as re-frame]
            [blacklist-ui.subs :as subs]
            [blacklist-ui.views.blacklist :refer [blacklist-panel]]
            ))


;; home

(defn home-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div (str "Hello from " @name ". This is the Home Page.")
     [:div [:a {:href "#/about"} "go to About Page"]]
     [:div [:a {:href "#/blacklist"} "go to Blacklist Page"]]]))


;; about

(defn about-panel []
  [:div "This is the About Page."
   [:div [:a {:href "#/"} "go to Home Page"]]
   [:div [:a {:href "#/blacklist"} "go to Blacklist Page"]]])


;; main

(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    :about-panel [about-panel]
    :blacklist-panel [blacklist-panel]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [show-panel @active-panel]))
