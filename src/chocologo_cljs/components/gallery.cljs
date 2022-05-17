(ns chocologo-cljs.components.gallery
  (:require [emotion.core :refer [defstyled defmedia]]
            [reagent.core :as r]
            [chocologo-cljs.theme.theme :refer [gallery-theme]]))

(def file-suffix ".jpeg")

(defn file-prefix [folder-key]
  (str "/static/" (name folder-key) "/chocolate"))

(defn get-file-names [folder-key count]
  (for [index (range 0 count)]
    (str (file-prefix folder-key) index file-suffix)))

(defmedia --responsive-gallery-img
  [nil
   "@media only screen and (min-width: 320px) and (max-width: 480px)"]
  [{:height (:height gallery-theme)
    :width (:width gallery-theme)}
   {:height (:height-responsive gallery-theme)
    :width (:width-responsive gallery-theme)}])

(defstyled gallery-img [:img {:wrap r/adapt-react-class}]
  {:object-fit "cover"
   :border-radius "10px!important"
   :margin "10px"} --responsive-gallery-img)

(defn row [& children]
  [:div.row.justify-content-center.text-center {:style {:width "100%"}} children])

(defn col [& children]
  [:div.col {:md "auto" :sm "auto" :xs "auto"} children])

(defn gallery [folder-key count]
  [:div {:style {:padding-top "30vh" :justify-content "center"}}
   [row
    (for [img-src (get-file-names folder-key count)]
      ^{:key img-src}[col ^{:key img-src}[gallery-img {:src img-src}]])]])