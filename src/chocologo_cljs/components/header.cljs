(ns chocologo-cljs.components.header
  (:require [reagent.core :as r]
            [emotion.core :refer [defmedia defstyled]]
            [chocologo-cljs.theme.theme :refer [header-theme header-description-theme]]
            [chocologo-cljs.components.navigation :refer [navigation]]
            ["react-awesome-reveal" :refer [Fade]]))

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

(defmedia --responsive-header
  [nil
   "@media (max-width: 768px)"]
  {}
  [{:font-size (:font-size header-theme)}
   {:font-size (:font-size-responsive header-theme)}])

(defmedia --responsive-description
  [nil
   "@media (max-width: 768px)"]
  {}
  [{:font-size (:font-size header-description-theme)}
   {:font-size (:font-size-responsive header-description-theme)}])

(defstyled button [:a {:wrap r/adapt-react-class}]
  {:z-index "1"
   :&:hover {:color (:color header-theme)}
   :color (:color header-theme)
   :text-decoration :none})

(defstyled header [:h1 {:wrap r/adapt-react-class}]
  {:grid-area "2/1/2/3"
   :align-self "center"
   :justify-self "center"
   :margin "-5rem 0 0"
   :color (:color header-theme)
   :font-size (:font-size header-theme)
   :font-family "Riesling, sans-serif"
   :font-weight "normal"
   :text-shadow "0 2px 4px rgba(0,0,0,0.4)"} --responsive-header)

(defstyled description [:p {:wrap r/adapt-react-class}]
  {:font-size (:font-size header-description-theme)
   :font-weight "normal"
   :align-self "center"
   :justify-self "center"
   :color (:color header-description-theme)
   :z-index "0"} --responsive-description)

(defmedia --header-div-responsive
  [nil
   "@media (max-width: 400px)"]
  [{:height "100vh"}
   {:height "125vh"}])

(defstyled header-div [:div {:wrap r/adapt-react-class}]
  {:width "100%"
   :position "relative"
   :display "flex"
   :flex-direction "column"
   :align-items "center"
   :align-content "center"
   :justify-content "center"
   :justify-items "center"} --header-div-responsive)

(defn main-header []
  [header-div
   [navigation]
   [background-image "/static/chocolate-background.jpg"]
   [header 
    [(r/adapt-react-class Fade) {:direction "up" :duration 1000 :triggerOnce true}
            [button {:href "/"} "Chocologo"]]]
   [:div {:style {:transform "translateY(-1rem)"}}
    [(r/adapt-react-class Fade) {:direction "up" :delay 1000 :duration 1000 :triggerOnce true}
     [description "Vaša najslađa poruka"]]]])
