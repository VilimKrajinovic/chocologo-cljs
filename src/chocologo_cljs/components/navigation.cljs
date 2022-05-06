(ns chocologo-cljs.components.navigation
  (:require [chocologo-cljs.service.i18n :refer [locale t]]))

(defn navigation []
  [:div {:style {:height "40px"
                 :display "flex"
                 :align-items "center"
                 :grid-area "1/1/1/3"
                 :padding "1rem 2rem"
                 :color "white"
                 :text-shadow "0px 2px 4px rgba(0,0,0,0.4)"
                 :z-index 1}}
   [:span (t :language-change)]
   [:span {:on-click #(reset! locale "en") 
           :style {:cursor "pointer", :padding "0 10px"}} (t :language-english)]
   [:span {:on-click #(reset! locale "hr") 
           :style {:cursor "pointer", :padding "0 10px"}} (t :language-croatian)]])