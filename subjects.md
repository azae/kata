# FizzBuzz

Any number divisible by 3 is replace by word Fizz and any divisible by five by the word Buzz. Number divisible by both become FizzBuzz.

Here are some use cases : 

    1 => 1
    2 => 2
    3 => Fizz
    4 => 4
    5 => Buzz
    6 => Fizz
    15 => FizzBuzz


# Leap Years

Write a function that returns true or false depending on wheter its input integer is a leap year or not.

A leap year is defined as one that is divisible by 4, ut is not otherwise divisible by 100 unless it is also divisible by 400.

For example, 2001 is typical common year and 1996 is a leap year, whereas 1900 is a typical common year and 2000 is an atypical leap year.

# FooBarQix

* Si le nombre est divisible par 3 on écrit "Foo" à la place de ce nombre
* si le nombre est divisible par 5, on ajoute "Bar",
* si le nombre est divisible par 7, on ajoute "Qix".
Les règles suivantes s'appliquent ensuite : 
* Pour chaque chiffre 3, 5 ou 7 que le nombre contient, on ajoute "Foo", "Bar" ou "Qix" dans l'ordre dans lequel ces chiffres sont rencontrés.

Voici un exemple de rendu :

    1  => 1
    2  => 2
    3  => FooFoo
    4  => 4
    5  => BarBar
    6  => Foo
    7  => QixQix
    8  => 8
    9  => Foo
    10 => Bar
    13 => Foo
    15 => FooBarBar
    21 => FooQix
    33 => FooFooFoo
    51 => FooBar
    53 => BarFoo

Une nouvelle demande business arrive, on veut pouvoir garder trace de la présence des 0 dans les nombres à transformer. Chaque 0 doit être remplacé par le caractère "*".

Voici un exemple de rendu :
    
    101   => 1*1
    303   => FooFoo*Foo
    105   => FooBarQix*Bar
    10101 => FooQix**


# String Calculator

## First step 
    
Create a StringCalculator class with a method 

    double add(String number)

* The method can take 0,1 or 2 numbers separated by comma and return their sum,
* an empty string will return 0
* Example of inputs : "", "1", "1.1,2.2"

## Allow the add method to handle an unknow number of arguments

## Allow the add method to handle new lines as separator

* "1\n2,3" should return 6.
* "1,\n" is invalid and throw an exception

## Allow the add method to handle a different delimiter

To change the delimiter, the beginning of the string will contain a separate line that looks like this : 

    "//[delimiter]\n[numbers]

Example : 

    "//;\n1;2"   => 3
    "//|\n1|2|3" => 6

All existing scenarios should work as before.

## Negatives numbers

Calling add with negatives numbers will throw an exception "Negative not allowed : " listing all negative numbers that were in the list of numbers

    "-1,2"    => Negative not allowed : -1
    "2,-4,"

# Roman Numerals

Write a function to convert from arabic numbers to roman numerals :

    1  => I
    7  => VII
    10 => X

There is no need to able to convert numbers larger than about 3000.

## Background information

Symbol values

    I : 1
    V : 5
    X : 10
    L : 50
    C : 100
    D : 500
    M : 1000

Symbols are placed in order of value, starting with the largest values. When smaller values precede larger values, the saller values are substracted from the larger values, and the result is added to the total. However, you can't write numerals like IM for 999, the are some additional rules :

* The symbols I, X C and M can be repeated thre times in succession, but no more.
* The symbols D, L and V can never be repeated.
* I can be substracted from V and X only.
* X can be substracted from L and C only.
* C can be substracted from D and M only.
* V, L and D can never be substracted
* Only one small value symbol may be substracted from any arger value symbol.

## Other direction

Write a function to convert in other direction, from roman numeral to arabic digits.
