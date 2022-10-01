(ns chocologo-cljs.components.fixed-background)

(defn fixed-background
  ([path children] (fixed-background {:height "60em"} path children))
  ([options path & children] (into [:div {:style {:position "relative"
                                                 :background-attachment "fixed"
                                                 :background-position "center"
                                                 :background-repeat "no-repeat"
                                                 :background-size "cover"
                                                 :height (:height options)
                                                 :min-height "100%"
                                                 :z-index "0"
                                                 :background-image (str "url(" path ")")}}] children)))
