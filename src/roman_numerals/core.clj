(ns roman-numerals.core)

(defn- convert-until-10 [arabic]
  (cond
    (= arabic 0) ""
    (= arabic 4) "IV"
    (= arabic 10) "X"
    (>= arabic 9) (str "IX" (convert-until-10 (- arabic 9)))
    (>= arabic 5) (str "V" (convert-until-10 (- arabic 5)))
    :else (str "I" (convert-until-10 (- arabic 1)))))

(defn arabic-to-roman [arabic]
  (cond 
    (<= arabic 10) (convert-until-10 arabic)
    (= arabic 40) "XL"
    (= arabic 50) "L"
    (= arabic 90) "XC"
    (= arabic 100) "C"
    (> arabic 100) (str "C" (arabic-to-roman (- arabic 100)))
    (> arabic 90) (str "XC" (arabic-to-roman (- arabic 90)))
    (> arabic 50) (str "L" (arabic-to-roman (- arabic 50)))
    (> arabic 40) (str "XL" (arabic-to-roman (- arabic 40)))
    :else (str "X" (arabic-to-roman (- arabic 10)))))
