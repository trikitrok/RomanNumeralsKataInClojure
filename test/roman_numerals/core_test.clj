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
        (arabic-to-roman 49) => "XLIX"
        (arabic-to-roman 50) => "L"
        (arabic-to-roman 89) => "LXXXIX")
  (fact "it converts numbers from 90 to 199"
        (arabic-to-roman 90) => "XC"
        (arabic-to-roman 99) => "XCIX"
        (arabic-to-roman 100) => "C"
        (arabic-to-roman 199) => "CXCIX")
  (fact "it converts numbers from 200 to 1000"
        (arabic-to-roman 200) => "CC"
        (arabic-to-roman 250) => "CCL"
        (arabic-to-roman 400) => "CD"
        (arabic-to-roman 499) => "CDXCIX"
        (arabic-to-roman 500) => "D"
        (arabic-to-roman 899) => "DCCCXCIX"
        (arabic-to-roman 900) => "CM"
        (arabic-to-roman 999) => "CMXCIX"
        (arabic-to-roman 1000) => "M"))
