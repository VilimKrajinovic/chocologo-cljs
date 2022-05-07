(ns chocologo-cljs.theme.theme)

(def text-color "white");
(def picture-link-size "300px")
(def picture-link-responsive-size "200px")

(def typography
  {:color text-color
   :font-size "1.2rem"})

(def header-theme
  {:font-size "8vw"
   :font-size-responsive "15vw"
   :color text-color})

(def header-description-theme
  {:font-size "1.3vw"
   :font-size-responsive "3vw"
   :color text-color})

(def picture-links-theme
  {:width picture-link-size
   :width-responsive picture-link-responsive-size
   :height picture-link-size
   :height-responsive picture-link-responsive-size})

(def gallery-theme
  {:width 500
   :height 500
   :width-responsive 200
   :height-responsive 200})