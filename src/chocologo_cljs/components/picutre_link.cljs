(ns chocologo-cljs.components.picutre-link
  (:require [chocologo-cljs.theme.theme :refer [picture-links-theme]]))

(defn description [text]
  [:p {:style {:font-size "2rem"
               :position "relative"
               :top "50%"
               :transform "translateY(-50%)"}} text])

(defn picture-link [text, href, img-url]
  [:div.col-md.picture-link {:style {:padding "0"
                                     :margin "10px"
                                     :height (:height (picture-links-theme))
                                     :width (:width (picture-links-theme))}}
   [:a {:href href}
    [:div.picture-link
     [:div.description-wrapper [description text]]
     [:img.picture-link {:src img-url}]]]])