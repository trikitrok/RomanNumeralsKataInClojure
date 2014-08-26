(ns roman-numerals.core)

(def ^:private roman-symbols
  {:until-10 "IVX"
   :until-100 "XLC"
   :until-1000 "CDM"
   :until-3999 "M  "})

(defn- convert [arabic in-range]
  (let [[from medium to] (roman-symbols in-range)]
    (cond
      (= arabic 0) ""
      (= arabic 10) (str to (convert (- arabic 10) in-range))
      (= arabic 4) (str from medium)
      (>= arabic 9) (str from to (convert (- arabic 9) in-range))
      (>= arabic 5) (str medium (convert (- arabic 5) in-range))
      :else (str from (convert (- arabic 1) in-range)))))

(declare huge-roman-numeral)

(defn arabic-to-roman [arabic]
  (cond
    (<= arabic 10) (convert arabic :until-10)
    (<= arabic 100) (str (convert (quot arabic 10) :until-100) 
                         (arabic-to-roman (mod arabic 10)))
    (<= arabic 1000) (str (convert (quot arabic 100) :until-1000)
                          (arabic-to-roman (mod arabic 100)))
    (<= arabic 3999) (str (convert (quot arabic 1000) :until-3999)
                          (arabic-to-roman (mod arabic 1000)))
    :else (huge-roman-numeral arabic)))

(defn- huge-roman-numeral [arabic]
  (let [thousand-multiple (arabic-to-roman (quot arabic 1000))]
            (str (apply str (repeat (count thousand-multiple) "-"))
                 "\n"
                 thousand-multiple
                 (arabic-to-roman (mod arabic 1000)))))