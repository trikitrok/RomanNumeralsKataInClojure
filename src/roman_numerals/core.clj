(ns roman-numerals.core)

(defn arabic-to-roman [arabic]
  (cond 
    (= arabic 1) "I"
    (= arabic 4) "IV"
    :else (str "I" (arabic-to-roman (- arabic 1)))))
