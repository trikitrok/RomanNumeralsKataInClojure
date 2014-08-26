(ns roman-numerals.core)

(defn- convert [from medium to from-symbol medium-symbol to-symbol arabic]
  (cond
    (= arabic 0) ""
    (= arabic (- medium from)) (str from-symbol 
                                      medium-symbol)
    (= arabic to) to-symbol
    (>= arabic (- to from)) (str from-symbol 
                                 to-symbol 
                                 (convert from 
                                          medium 
                                          to 
                                          from-symbol 
                                          medium-symbol 
                                          to-symbol 
                                          (- arabic (- to from))))
    (>= arabic medium) (str medium-symbol 
                            (convert from 
                                     medium 
                                     to 
                                     from-symbol 
                                     medium-symbol 
                                     to-symbol 
                                     (- arabic medium)))
    :else (str from-symbol 
               (convert from 
                        medium 
                        to 
                        from-symbol 
                        medium-symbol 
                        to-symbol 
                        (- arabic from)))))

(def ^:private convert-until-10
  (partial convert 1 5 10 "I" "V" "X"))

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
