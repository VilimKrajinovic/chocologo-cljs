(ns chocologo-cljs.core
  (:require
   [chocologo-cljs.components.header :as header]
   [chocologo-cljs.components.angled-strip :refer [angled-strip]]
   [chocologo-cljs.components.fixed-background :refer [fixed-background]]
   [chocologo-cljs.components.caption :refer [caption]]
   [chocologo-cljs.components.picutre-link :refer [picture-link]]
   [chocologo-cljs.service.i18n :refer [t]]
   [reitit.frontend :as reitit]
   [reitit.frontend.easy :as rfe]
   [reitit.coercion.spec :as rcs]
   [fipp.edn :as fedn]
   [spec-tools.data-spec :as ds]
   [reagent.core :as r]
   [reagent.dom :as d]))

;; -------------------------
;; Helpers

(defn container [& children]
  [:div.container {:style {:padding-top "30vh"
                           :width "80vw"}
                   :md "auto"
                   :xs "auto"
                   :sm "auto"} children])

(defn col [& children]
  [:div.col {:style {:float "none", :margin "0 auto"}} children])

(defn row [& children]
  [:div.row.justify-content-center.text-center children])

;; -------------------------
;; Views


(defn home []
  [:<>
   [angled-strip (t :title) (t :title-description)]
   [fixed-background "/static/first.jpg" [caption (t :bubble-first)]]
   [angled-strip (t :title-second) (t :title-second-description)]
   [fixed-background "/static/chocolate1.jpeg" [caption (t :bubble-second)]]
   [angled-strip (t :title-third) nil]
   [fixed-background "/static/chocolate-background.jpg" "auto"
    [container
     [row
      [col [picture-link "Description" "/birthdays" "/static/chocolate1.jpeg"]]
      [col [picture-link "Description" "/birthdays" "/static/chocolate1.jpeg"]]
      [col [picture-link "Description" "/birthdays" "/static/chocolate1.jpeg"]]
      [col [picture-link "Description" "/birthdays" "/static/chocolate1.jpeg"]]
      [col [picture-link "Description" "/birthdays" "/static/chocolate1.jpeg"]]
      [col [picture-link "Description" "/birthdays" "/static/chocolate1.jpeg"]]]]]])

(defn birthdays []
  [:div [:h1 "This is the birthdays page"]])

;; -------------------------
;; Routes

(def routes [["/" {:name ::frontpage
                   :view home}]
             ["/birthdays" {:name ::birthdays
                            :view birthdays}]])

;; -------------------------
;; Initialize app

(defonce match (r/atom nil))

(defn current-page []
  [:div
   [header/main-header]
   (if @match
     (let [view (:view (:data @match))]
       [view @match]))])

(defn init! []
  (rfe/start!
   (reitit/router routes {:data {:coercion rcs/coercion}})
   (fn [m] (reset! match m))
   {:use-fragment false})
  (d/render [current-page] (.getElementById js/document "app")))

(init!)