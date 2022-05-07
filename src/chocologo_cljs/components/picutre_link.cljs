(ns chocologo-cljs.components.picutre-link
  (:require [chocologo-cljs.theme.theme :refer [picture-links-theme]]
            [reagent.core :as r]
            [emotion.core :refer [defstyled defmedia]]))


(defmedia --responsive-div-wrapper
  [nil
   "@media(min-width: 200px) and (max-width: 480px)"]
  [{:height (:height picture-links-theme)
    :width (:width picture-links-theme)}
   {:height (:height-responsive picture-links-theme)
    :margin "10px auto"
    :width (:width-responsive picture-links-theme)}])

(defmedia --responsive-description-wrapper
  [nil
   "@media(min-width: 200px) and (max-width: 480px)"]
  [{:height (:height picture-links-theme)
    :width (:width picture-links-theme)
    :opacity "0%"
    :visibility "invisible"}
   {:height (:height-responsive picture-links-theme)
    :width (:width-responsive picture-links-theme)
    :opacity "100%"
    :visibility "visible"}])

(defstyled div-wrapper [:div {:wrap r/adapt-react-class}]
  {:padding "0"
   :margin "10px"} --responsive-div-wrapper)

(defstyled picture [:img {:wrap r/adapt-react-class}]
  {:padding "0"
   :object-fit "cover"
   :border-radius "10px!important"
   :margin "0px"} --responsive-div-wrapper)

(defstyled description-wrapper [:div {:wrap r/adapt-react-class}]
  {:position "absolute";
   :background "rgba (247, 119, 0, 0.2)"
   :color "white"
   :opacity "0"
   :border-radius "10px"
   :margin "0"
   :text-align "center"
   :&:hover {:opacity "100%" :visibility "visible"}
   :transition "opacity 0.2s"} --responsive-description-wrapper)

(defstyled description [:div {:wrap r/adapt-react-class}]
  {:font-size "2rem"
   :position "relative"
   :text-shadow "2px 2px 1px rgba(0,0,0,0.9)"
   :top "50%"
   :transform "translateY(-50%)"})

(defn picture-link [text, href, img-url]
  [div-wrapper {:class "col-md"}
   [:a {:href href}
    [div-wrapper
     [description-wrapper [description text]]
     [picture {:src img-url}]]]])