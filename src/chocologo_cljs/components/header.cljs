(ns chocologo-cljs.components.header
  (:require [reagent.core :as r]))

(defn chocologo-header [text-color]
  [:h1 {:style {:grid-area "2/1/2/3"
                :align-self "center"
                :justify-self "center"
                :margin "-5rem 0 0"
                :color text-color
                :font-size "6vw"
                :font-weight "normal"
                :text-shadow "0 2px 4px rgba(0,0,0,0.4)"}}
   [:a {:style {:z-index "-1"
                :color text-color
                :text-decoration "none"
                :hover {:color "black", :text-decoration "none"}}
        :href "/"} "Chocologo"]])

(defn chocologo-header-description []
  [:p {:style {:font-size "1vw"
               :font-weight "normal"
               :align-self "center"
               :justify-self "center"
               :color "red"
               :grid-area "2/1/2/3"
               :margin "3vh 0 0 0"
               :z-index "0"}}
   "Vasa najslada poruka"])

(defn main-header []
  [:div {:style {:width "100%"
                 :height "100vh"
                 :position "relative"
                 :display "grid"
                 :grid-template-rows "max-content 1fr"
                 :grid-template-columns "1fr max-content"}}
   [chocologo-header "red"]
   [chocologo-header-description]])
