(ns chocologo-cljs.components.fixed-background)

(defn fixed-background [path & children]
  [:div {:style {:position "relative"
                 :background-attachment "fixed"
                 :background-position "center"
                 :background-repeat "no-repeat"
                 :background-size "cover"
                 :height "60em"
                 :min-height "100%"
                 :z-index "0"
                 :background-image (str "url(" path ")")}} children])