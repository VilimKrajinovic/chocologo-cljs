(ns chocologo-cljs.theme.theme)

;; -----------------------
;; Header

(def header-color "white");

(defn header-theme []
  {:font-size "6vw"
   :color header-color})

(defn header-description-theme []
  {:font-size "1vw"
   :color header-color})