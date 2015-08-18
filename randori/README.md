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
