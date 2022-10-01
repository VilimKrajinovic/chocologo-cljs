(ns chocologo-cljs.core
  (:require
   [chocologo-cljs.components.header :as header]
   [chocologo-cljs.components.angled-strip :refer [angled-strip]]
   [chocologo-cljs.components.fixed-background :refer [fixed-background]]
   [chocologo-cljs.components.caption :refer [caption]]
   [chocologo-cljs.components.picutre-link :refer [picture-link]]
   [chocologo-cljs.components.gallery :refer [gallery]]
   [chocologo-cljs.service.i18n :refer [get-translations]]
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
  (into [:div.container {:style {:padding-top "30vh"
                                 :width "80vw"}
                         :md "auto"
                         :xs "auto"
                         :sm "auto"}] children))

(defn col [& children]
  (into [:div.col {:style {:margin "0 auto"
                           :justify-content "center"
                           :align-items "center"
                           :display "flex"}}] children))

(defn row [& children]
  (into [:div.row.justify-content-center.text-center] children))

;; -------------------------
;; Views


(defn home []
  [:<>
   [angled-strip (:title (get-translations)) (:title-description (get-translations))]
   [fixed-background "/static/first.jpg" [caption (:bubble-first (get-translations))]]
   [angled-strip (:title-second (get-translations)) (:title-second-description (get-translations))]
   [fixed-background "/static/chocolate1.jpeg" [caption (:bubble-second (get-translations))]]
   [angled-strip (:title-third (get-translations)) (:title-third-description (get-translations))]
   [fixed-background {:height "auto"} "/static/brown-gradient.jpeg"
    [container
     [row
      [col [picture-link (:products-rectangular-caption (get-translations)) "/rectangular" "/static/chocolate1.jpeg"]]
      [col [picture-link "Description" "/birthdays" "/static/chocolate1.jpeg"]]
      [col [picture-link "Description" "/birthdays" "/static/chocolate1.jpeg"]]
      [col [picture-link "Description" "/birthdays" "/static/chocolate1.jpeg"]]
      [col [picture-link "Description" "/birthdays" "/static/chocolate1.jpeg"]]
      [col [picture-link "Description" "/birthdays" "/static/chocolate1.jpeg"]]]]]])

(defn rectangular-view []
  [:<>
   [angled-strip (:products-rectangular-title (get-translations)) (:products-rectangular-description (get-translations))]
   [fixed-background {:height "auto"} "/static/brown-gradient.jpeg"
    [gallery :rectangular 4]]])

;; -------------------------
;; Routes

(def routes [["/" {:name ::frontpage
                   :view home}]
             ["/rectangular" {:name ::rectangular
                              :view rectangular-view}]])

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