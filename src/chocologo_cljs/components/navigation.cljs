(ns chocologo-cljs.components.navigation
  (:require [chocologo-cljs.service.i18n :refer [locale get-translations]]))

(defn navigation []
  [:div {:style {:height "40px"
                 :position "absolute"
                 :top 0
                 :left 0
                 :align-items "center"
                 :padding "1rem 2rem"
                 :color "white"
                 :text-shadow "0px 2px 4px rgba(0,0,0,0.4)"
                 :z-index 1}}
   [:span (:language-change (get-translations))]
   [:span {:on-click #(reset! locale "en")
           :style {:cursor "pointer", :padding "0 10px"}} (:language-english (get-translations))]
   [:span {:on-click #(reset! locale "hr")
           :style {:cursor "pointer", :padding "0 10px"}} (:language-croatian (get-translations))]])