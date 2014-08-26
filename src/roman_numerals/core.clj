(ns roman-numerals.core)

(defn arabic-to-roman [arabic]
  (if (= arabic 1)
    "I"
    (str "I" (arabic-to-roman (- arabic 1)))))
