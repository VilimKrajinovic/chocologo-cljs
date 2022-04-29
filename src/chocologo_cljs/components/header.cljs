(ns chocologo-cljs.components.header
  (:require [reagent.core :as r]
            [chocologo-cljs.theme.theme :refer [header-theme header-description-theme]]))

(defn background-image [img]
  [:div {:style {:width "100%"
                 :height "100%"
                 :background-size "cover"
                 :background-position "center"
                 :background-image (str "url(" img ")")
                 :filter "brightness(50%)"
                 :position "absolute"
                 :background-attachment "fixed"
                 :background-repeat "no-repeat"
                 :top "0"
                 :left "0"
                 :z-index "-1"}}])

(defn header []
  [:h1 {:style {:grid-area "2/1/2/3"
                :align-self "center"
                :justify-self "center"
                :margin "-5rem 0 0"
                :color (:color (header-theme))
                :font-size (:font-size (header-theme))
                :font-family "Riesling, sans-serif"
                :font-weight "normal"
                :text-shadow "0 2px 4px rgba(0,0,0,0.4)"}}
   [:a {:style {:z-index "1"
                :color (:color (header-theme))
                :text-decoration "none"}
        :href "/"} "Chocologo"]])

(defn description []
  [:p {:style {:font-size (:font-size (header-description-theme))
               :font-weight "normal"
               :align-self "center"
               :justify-self "center"
               :color (:color (header-description-theme))
               :grid-area "2/1/2/3"
               :margin "3vh 0 0 0"
               :z-index "0"}}
   "Vaša najslađa poruka"])

(defn main-header []
  [:div {:style {:width "100%"
                 :height "100vh"
                 :position "relative"
                 :display "grid"
                 :grid-template-rows "max-content 1fr"
                 :grid-template-columns "1fr max-content"}}
   [background-image "/static/chocolate-background.jpg"]
   [header]
   [description]])
