(ns chocologo-cljs.service.i18n
  [:require [chocologo-cljs.translations.translations :refer [translations]]
   [reagent.core :as r]])

(def locale (r/atom "en"))

(defn find-translation [translation-map keyword]
  (let [result (get translation-map keyword)]
    (if (nil? result)
      (name keyword)
      result)))

(defn t [keyword] (case @locale
                    "en" (find-translation (get (translations) :en) keyword)
                    "hr" (find-translation (get (translations) :hr) keyword)))