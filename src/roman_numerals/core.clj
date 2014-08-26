(ns roman-numerals.core)

(def ^:private roman-symbols
  {0 ""
   1 "I"
   5 "V"
   10 "X"})

(defn- convert [from medium to arabic]
  (cond
    (= arabic 0) ""
    (= arabic to) (roman-symbols to)
    (= arabic (- medium from)) (str (roman-symbols from) (roman-symbols medium))
    (>= arabic (- to from)) (str (roman-symbols from) (roman-symbols to) 
                                 (convert from medium to (- arabic (- to from))))
    (>= arabic medium) (str (roman-symbols medium) 
                            (convert from medium to (- arabic medium)))
    :else (str (roman-symbols from)
               (convert from medium to (- arabic from)))))

(defn arabic-to-roman [arabic]
  (cond
    (<= arabic 10) (convert 1 5 10 arabic)
    (>= arabic 100) (str "C" (arabic-to-roman (- arabic 100)))
    (>= arabic 90) (str "XC" (arabic-to-roman (- arabic 90)))
    (>= arabic 50) (str "L" (arabic-to-roman (- arabic 50)))
    (>= arabic 40) (str "XL" (arabic-to-roman (- arabic 40)))
    :else (str "X" (arabic-to-roman (- arabic 10)))))
