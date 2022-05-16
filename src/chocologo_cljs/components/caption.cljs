(ns chocologo-cljs.components.caption
  (:require [chocologo-cljs.theme.theme :refer [typography]]))

(defn rounded-box [caption]
  [:div {:style {:border-radius "20px"
                 :position "absolute"
                 :background "linear-gradient(90deg, #f77700 10%, #bf6000 90%)"
                 :width "20rem"
                 :left "100%"
                 :color "#f7f7f7"
                 :text-align "center"
                 :transform "translate(-50%, 0%)"
                 :height "auto"
                 :padding "10px"}}
   [:span {:style {:text-align "center";
                   :color (:color typography);
                   :width "100%";
                   :font-family "Lato, sans-serif";
                   :text-transform "uppercase";
                   :font-size "25px";        
                   }}caption]])

(defn caption [text]
  [:div {:style {:position "absolute"
                 :top "50%"
                 :left "50%"}}
   [rounded-box text]])