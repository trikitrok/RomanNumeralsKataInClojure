(ns roman-numerals.core-test
  (:use midje.sweet)
  (:use [roman-numerals.core]))

(facts 
  "about arabic to roman numerals conversion"
  (fact "it converts numbers until 10"
        (arabic-to-roman 1) => "I"
        (arabic-to-roman 2) => "II"
        (arabic-to-roman 3) => "III"
        (arabic-to-roman 4) => "IV"))
