(ns chocologo-cljs.theme.theme)

;; -----------------------
;; Header

(def text-color "white");
(def picture-link-size "300px")

(defn typography []
  {:color text-color})

(defn header-theme []
  {:font-size "6vw"
   :font-size-responsive "15vw"
   :color text-color})

(defn header-description-theme []
  {:font-size "1vw"
   :font-size-responsive "3vw"
   :color text-color})

(defn picture-links-theme []
  {:width picture-link-size :height picture-link-size})