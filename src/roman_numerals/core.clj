(ns roman-numerals.core)

(defn arabic-to-roman [arabic]
  (cond 
    (= arabic 1) "I"
    (= arabic 4) "IV"
    (= arabic 5) "V"
    (= arabic 9) "IX"
    (> arabic 5) (str "V" (arabic-to-roman (- arabic 5)))
    :else (str "I" (arabic-to-roman (- arabic 1)))))
