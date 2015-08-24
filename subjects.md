
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

# RPN Calculator

An RPN calculator computes expressions written in Reverse Polish Notation.

An RPN expression or postfix expression is one of the following :
* a number X, in wich case the value of the expression is that of X,
* a sequence of form E1 E2 O where E1 and E2 are RPN expressions and O is an arithmetic operation.

Samples : 

    20 5 /        => 20/5 = 4
    4 2 + 3 -     => (4+2)-3 = 3
    3 5 8 * 7 + * => ((5*8)+7)*3 = 141
  
Add the SQRT operation :

    9 SQRT => √9 = 3

Add the MAX operation : 

    5 3 4 2 9 1 MAX   => MAX(5, 3, 4, 2, 9, 1) = 9
    4 5 MAX 1 2 MAX * => MAX(4,5) * MAX(1,2) = 10 


