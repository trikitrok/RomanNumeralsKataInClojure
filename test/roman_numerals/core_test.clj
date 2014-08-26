(ns roman-numerals.core-test
  (:use midje.sweet)
  (:use [roman-numerals.core]))

(facts 
  "about arabic to roman numerals conversion"
  (fact "it converts numbers until 10"
        (arabic-to-roman 1) => "I"
        (arabic-to-roman 2) => "II"
        (arabic-to-roman 3) => "III"
        (arabic-to-roman 4) => "IV"
        (arabic-to-roman 5) => "V"
        (arabic-to-roman 8) => "VIII"
        (arabic-to-roman 9) => "IX"
        (arabic-to-roman 10) => "X")
  (fact "it converts numbers from 10 to 39"
        (arabic-to-roman 13) => "XIII"
        (arabic-to-roman 14) => "XIV"
        (arabic-to-roman 25) => "XXV"
        (arabic-to-roman 28) => "XXVIII"
        (arabic-to-roman 39) => "XXXIX")
  (fact "it converts numbers from 40 to 89"
        (arabic-to-roman 40) => "XL"
        (arabic-to-roman 50) => "L"))
