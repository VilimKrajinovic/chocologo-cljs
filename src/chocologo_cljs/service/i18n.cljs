(ns chocologo-cljs.service.i18n
  [:require [chocologo-cljs.translations.translations :refer [locale->translations]]
   [reagent.core :as r]])

(def locale (r/atom "en"))

(defn find-translation [translation-map keyword]
  (let [result (get translation-map keyword)]
    (if (nil? result)
      (name keyword)
      result)))

(defn get-translations [] (case @locale
                    "en"  (get locale->translations :en) 
                    "hr"  (get locale->translations :hr))) 