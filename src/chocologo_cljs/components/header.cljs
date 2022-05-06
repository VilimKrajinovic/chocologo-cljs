(ns chocologo-cljs.components.header
  (:require [reagent.core :as r]
            [emotion.core :refer [defmedia defstyled]]
            [chocologo-cljs.theme.theme :refer [header-theme header-description-theme]]
            [chocologo-cljs.components.navigation :refer [navigation]]))

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

#_{:clj-kondo/ignore [:unresolved-symbol]}
(defmedia --responsive-header
  [nil
   "@media (max-width: 768px)"]
  {}
  [{:font-size (:font-size (header-theme))}
   {:font-size (:font-size-responsive (header-theme))}])

#_{:clj-kondo/ignore [:unresolved-symbol]}
(defmedia --responsive-description
  [nil
   "@media (max-width: 768px)"]
  {}
  [{:font-size (:font-size (header-description-theme))}
   {:font-size (:font-size-responsive (header-description-theme))}])

#_{:clj-kondo/ignore [:unresolved-symbol]}
(defstyled button [:a {:wrap r/adapt-react-class}]
  {:z-index "1"
   :&:hover {:color (:color (header-theme))}
   :color (:color (header-theme))
   :text-decoration :none})

#_{:clj-kondo/ignore [:unresolved-symbol]}
(defstyled header [:h1 {:wrap r/adapt-react-class}]
  {:grid-area "2/1/2/3"
   :align-self "center"
   :justify-self "center"
   :margin "-5rem 0 0"
   :color (:color (header-theme))
   :font-size (:font-size (header-theme))
   :font-family "Riesling, sans-serif"
   :font-weight "normal"
   :text-shadow "0 2px 4px rgba(0,0,0,0.4)"} --responsive-header)

#_{:clj-kondo/ignore [:unresolved-symbol]}
(defstyled description [:p {:wrap r/adapt-react-class}]
  {:font-size (:font-size (header-description-theme))
   :font-weight "normal"
   :align-self "center"
   :justify-self "center"
   :color (:color (header-description-theme))
   :grid-area "2/1/2/3"
   :margin "3vh 0 0 0"
   :z-index "0"} --responsive-description)

#_{:clj-kondo/ignore [:unresolved-symbol]}
(defmedia --header-div-responsive
  [nil
   "@media (max-width: 400px)"]
  [{:height "100vh"}
   {:height "125vh"}])

#_{:clj-kondo/ignore [:unresolved-symbol]}
(defstyled header-div [:div {:wrap r/adapt-react-class}]
  {:width "100%"
   :position "relative"
   :display "grid"
   :grid-template-rows "max-content 1fr"
   :grid-template-columns "1fr max-content"} --header-div-responsive)

#_{:clj-kondo/ignore [:unresolved-symbol]}
(defn main-header []
  [header-div
   [navigation]
   [background-image "/static/chocolate-background.jpg"]
   [header [button {:href "/"} "Chocologo"]]
   [description "Vaša najslađa poruka"]])
