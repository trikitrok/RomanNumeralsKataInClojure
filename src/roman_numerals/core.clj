(ns roman-numerals.core)

(defn arabic-to-roman [arabic]
  (cond 
    (= arabic 1) "I"
    (= arabic 4) "IV"
    (= arabic 5) "V"
    (= arabic 9) "IX"
    (= arabic 10) "X"
    (= arabic 40) "XL"
    (> arabic 10) (str "X" (arabic-to-roman (- arabic 10)))
    (> arabic 5) (str "V" (arabic-to-roman (- arabic 5)))
    :else (str "I" (arabic-to-roman (- arabic 1)))))
