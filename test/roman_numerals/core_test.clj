(ns roman-numerals.core-test
  (:use midje.sweet)
  (:use [roman-numerals.core]))

(facts 
  "about arabic to roman numerals conversion"
  (fact "1 converts to I"
        (arabic-to-roman 1) => "I"))
