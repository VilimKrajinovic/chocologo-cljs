(ns chocologo-cljs.core
  (:require
  [chocologo-cljs.components.header :as header] 
  [chocologo-cljs.components.angled-strip :refer [angled-strip]]
   [reitit.frontend :as reitit]
   [reitit.frontend.easy :as rfe]
   [reitit.coercion.spec :as rcs]
   [fipp.edn :as fedn]
   [spec-tools.data-spec :as ds]
   [reagent.core :as r]
   [reagent.dom :as d]))

;; -------------------------
;; Views


(defn home []
  [angled-strip "Who we are?" "We are a small chocolate company located in Zagreb, Croatia\nOur chocolates are made with the finest Belgian ingredients and melted on perfect temperatures\nDecorated with your own personalized photos and logos."])

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
       [view @match]))
   ])

(defn init! []
  (rfe/start!
   (reitit/router routes {:data {:coercion rcs/coercion}})
   (fn [m] (reset! match m))
   {:use-fragment false})
  (d/render [current-page] (.getElementById js/document "app")))

(init!)