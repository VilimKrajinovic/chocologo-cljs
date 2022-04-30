(ns chocologo-cljs.components.angled-strip
  (:require [chocologo-cljs.theme.theme :refer [typography]]))

(defn skew [strip]
  [:div {:style {:transform "skewY(-5deg)"
                 :position "relative"
                 :z-index "2"}} strip])

(defn unskew [content]
  [:div {:style {:transform "skewY(5deg)"
                 :position "relative"
                 :z-index "2"}} content])

(defn strip [content]
  [:div {:style {:width "100%",
                 :height "auto"
                 :min-height "5rem"
                 :margin "-10rem 0 0 0"
                 :position "absolute"
                 :background "linear-gradient(90deg, #f77700 10%, #bf6000 90%)"
                 :z-index "1000 !important"}} content])

(defn title [text]
  [:h2 {:style {:font-weight "normal"
                :color (:color (typography))
                :margin "0"}} text])

(defn description [text]
  [:p {:style {:white-space "pre-wrap"
               :color (:color (typography))
               :margin "5% auto 5rem"
               :width "80%"}} text])

(defn content [title-text, description-text]
  [:div {:style {:padding-top "4rem"
                 :text-align "center"}}
   [title title-text]
   [description description-text]])

(defn angled-strip [title, desc]
  [:div [skew [strip [unskew [content title desc]]]]])
