(ns chocologo-cljs.theme.theme)

;; -----------------------
;; Header

(def text-color "white");

(defn typography []
{:color text-color}  )

(defn header-theme []
  {:font-size "6vw"
   :color text-color})

(defn header-description-theme []
  {:font-size "1vw"
   :color text-color})