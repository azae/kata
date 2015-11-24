
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

# Kata Tennis

Tennis has a rather quirky scoring system, and to newcomers it can be a little difficult to keep track of. The Tennis Society has contracted you to build a scoreboard to display the current score during tennis games. The umpire will have a handset with two buttons labelled “player 1 scores” and “player 2 scores”, which he or she will press when the respective players score a point. When this happens, a big scoreboard display should update to show the current score. (When you first switch on the scoreboard, both players are assumed to have no points). When one of the players has won, the scoreboard should display which one. Your task is to write a “TennisGame” class containing the logic which outputs the correct score as a string for display on the scoreboard. You can assume that the umpire pressing the button “player 1 scores” will result in a method “WonPoint(“player1”)” being called on your class, and similarly WonPoint(“player2”) for the other button. Afterwards, you will get a call “Score” from the scoreboard asking what it should display. This property should return a string with the current score.

1. A game is won by the first player to have won at least four points in total and at least two points more than the opponent. The score is then “Win for player1” or “Win for player2”

2. The running score of each game is described in a manner peculiar to tennis: scores from zero to three points are described as “Love”, “Fifteen”, “Thirty”, and “Forty” respectively.

3. If at least three points have been scored by each player, and the scores are equal, the score is “Deuce”. 

4. If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is “Advantage player1” or “Advantage player2”.

The Tennis Society has agreed that Sets and Matches are out of scope, so you only need to report the score for the current game. However, they have requested another feature with lower priority. They want to be able to change the name of the players from “player1” to “Björn Borg” and “player2” to “John McEnroe”. This feature has been categorized “Nice to have”, or, more accurately, “in your dreams”!


# Random Walk

Charles is a nice guy that has a bad tendency to drink a bit too much. And especialy tonight! He’s just leaving the bar, and needs to come back home. His home is just 5 steps away from the bar, in the same street. 
The problem is that he is drunk! So every step he makes is random: it can bring him closer to home, or take him away from it!
Knowing that he will fall aspleep after 40 steps, how many nights will he spend in his bed after 100 days?

Charles would like to get away from his bad drinking habit. So he decides to move to Manhattan. Manhattan is a very well organized city, where avenues run from north to south, and streets from west to east. Finding his home is more tricky there. At each intersection he forgets from where he’s coming, and chooses randomly his new direction. 
Knowing that he has to walk 5 blocks east and 5 blocks north, that he will fall asleep after having crossed 1000 intersections, and that he goes to the bar every night, how many nights will he spend in his bed after 1000 days?

In fact Mahnattan is even better organized that we think. Streets and avenues are one way. Even streets go from west to east, and even avenues go from north to south. Odd streets and avenues go the opposite way. Charles has stopped drinking alcohol, so now he can take his car to come back home. But he keeps choosing randomly his direction at each intersection. Has the number of nights he will spend in his bed improved?

Charles tries really hard to solve his lack of sleep problem. So now he takes a notebook with him. Everytime he goes through a new intersection, he keeps track of the direction he’s choosing. And if he goes through this intersection again, since he has not find his home, he will try to take another way. If he arrives at an intersection where he already explored all the possible ways, he decide sto stay in his car and to sleep there. Has the number of nights he will spend in his bed improved?

Charles would like to try another way of finding his ways in this maze. So this time, if he arrives at an unknown intersection, he chooses to take the avenue, to the north or the south, randomly. If he arrives at a known intersection, he chooses to take the street, to the east or the west, chosen randomly. Has the number of nights he will spend in his bed improved?

# Papous

Le gag 464 de Gaston Lagaffe contient une histoire assez connue : celle des Papous à poux et des Papous pas à poux. 
D’une façon générale :
-	un Papou peut être papa ou pas papa ;
-	un Papou peut être à poux ou pas à poux ;
-	un pou peut être papa ou pas papa.
On considère que les Papous pas à poux papa et que les Papous pas à poux pas papa sont la même catégorie. 

Il y a donc quatre catégories de Papous : 
-	les Papous papas et les papous pas papas ;
-	les Papous à pous et la Papous pas à pous. 

Écrire une fonction qui prend une chaîne de caractère, par exemple “Papous”, et qui retourne une liste de chaînes de caractères décrivant toutes les sous-catégories de “Papous” dans notre exemple. 

Notre fonction doit donc répondre de la façon suivante : 
```
Papous papas	=> Papous papa à pous, 
	   Papous papa pas à pous
Papous à pous	=> Papous papa à pous, 
	   Papous pas papa à pous
Papous	=> Papous papa à pous, 
	   Papous papa pas à pous, 
	   Papous pas papa à pous, 
	   Papous pas papa pas à pous
```

Il y a deux catégories de poux : 
-	les poux papas et les poux pas papa.
Ce qui transforme les résultats de la façon suivante :
```
Papous papas	=> Papous papas à pous papas,
	   Papous papas à pous pas papas, 
	   Papous papas pas à pous
Papous à pous	=> Papous papas à pous papas, 
	   Papous papas à pous pas papas,
	   Papous pas papas à pous
Papous	=> Papous papas à pous papas, 
	   Papous papas à pous pas papas,
	   Papous papas pas à pous, 
	   Papous pas papas à pous papas, 
	   Papous pas papas à pous pas papas,
	   Papous pas papas pas à pous
```

Les spécialistes des pous se sont intéressés à la population des poux en Papouasie. Et ils ont découvert des sous-catégories : 
-	des pous eux-mêmes peuvent être Papou ou pas Papou.
En revanche :
-	un pou ne peut pas être à poux ;
-	et donc un pou pas à poux n’a pas de sens non plus. 

Avec ces nouvelles règles, quelles sont les sous-catégories de Papous papas ? Quelles sont toutes les catégories de Papous papas ?

# Args

KATA Most of us have had to parse command-line arguments from time to time. If we don’t have a convenient utility, then we simply walk the array of strings that is passed into the main function. There are several good utilities available from various sources, but they probably don’t do exactly what we want. So let’s write another one!
The arguments passed to the program consist of flags and values. Flags should be one character, preceded by a minus sign. Each flag should have zero, or one value associated with it.

You should write a parser for this kind of arguments. This parser takes a schema detailing what arguments the program expects. The schema specifies the number and types of flags and values the program expects.

Once the schema has been specified, the program should pass the actual argument list to the args parser. It will verify that the arguments match the schema. The program can then ask the args parser for each of the values, using the names of the flags. The values are returned with the correct types, as specified in the schema.

For example if the program is to be called with these arguments:

-l -p 8080 -d /usr/logs 

this indicates a schema with 3 flags: l, p, d. 

The “l” (logging) flag has no values associated with it, it is a boolean flag, True if present, False if not. 
The “p” (port) flag has an integer value, and the “d” (directory) flag has a string value.
If a flag mentioned in the schema is missing in the arguments, a suitable default value should be returned. For example “False” for a boolean, 0 for a number, and “” for a string.

If the arguments given do not match the schema, it is important that a good error message is given, explaining exactly what is wrong.
If you are feeling ambitious, extend your code to support lists eg

-g this,is,a,list -d 1,2,-3,5

So the “g” flag indicates a list of strings, [“this”, “is”, “a”, “list”] and the “d” flag indicates a list of integers, [1, 2, -3, 5].
Make sure your code is extensible, in that it is straightforward and   obvious how to add new types of values.

# Minesweeper

Have you ever played Minesweeper? It’s a cute little game which comes within a certain Operating System whose name we can’t really remember. Well, the goal of the game is to find all the mines within an MxN field. To help you, the game shows a number in a square which tells you how many mines there are adjacent to that square. For instance, take the following 4x4 field with 2 mines (which are represented by an * character):

    * . . .
    . . . .
    . * . .
    . . . .
The same field including the hint numbers described above would look like this:

    * 1 0 0
    2 2 1 0
    1 * 1 0
    1 1 1 0

You should write a program that takes input as follows:
The input will consist of an arbitrary number of fields. The first line of each field contains two integers n and m (0 < n,m <= 100) which stands for the number of lines and columns of the field respectively. The next n lines contains exactly m characters and represent the field. Each safe square is represented by an “.” character (without the quotes) and each mine square is represented by an “*” character (also without the quotes). The first field line where n = m = 0 represents the end of input and should not be processed.

Your program should produce output as follows: 
For each field, you must print the following message in a line alone:
Field #x:
Where x stands for the number of the field (starting from 1).
The next n lines should contain the field with the “.” Characters replaced by the number of adjacent mines to that square.
There must be an empty line between field outputs.
This is the acceptance test input:
4 4

    * . . .
    . . . .
    . * . .
    . . . .

3 5

    * * . . .
    . . . . .
    . * . . .

0 0

and output:

Field #1:

    * 1 0 0
    2 2 1 0
    1 * 1 0
    1 1 1 0

Field #2:

    * * 1 0 0
    3 3 2 0 0
    1 * 1 0 0

# Tic-Tac-Toe-Tomek

Tic-Tac-Toe-Tomek is a game played on a 4 x 4 square board. The board starts empty, except that a single 'T' symbol may appear in one of the 16 squares. There are two players: X and O. They take turns to make moves, with X starting. In each move a player puts her symbol in one of the empty squares. Player X's symbol is 'X', and player O's symbol is 'O'. 
After a player's move, if there is a row, column or a diagonal containing 4 of that player's symbols, or containing 3 of her symbols and the 'T' symbol, she wins and the game ends. Otherwise the game continues with the other player's move. If all of the fields are filled with symbols and nobody won, the game ends in a draw. See the sample input for examples of various winning positions. 
Given a 4 x 4 board description containing 'X', 'O', 'T' and '.' characters (where '.' represents an empty square), describing the current state of a game, determine the status of the Tic-Tac-Toe-Tomek game going on. The statuses to choose from are: 

- "X won" (the game is over, and X won) 
- "O won" (the game is over, and O won) 
- "Draw" (the game is over, and it ended in a draw) 
- "Game has not completed" (the game is not over yet) 

If there are empty cells, and the game is not over, you should output "Game has not completed", even if the outcome of the game is inevitable. 
Input
The first line of the input gives the number of test cases, T. T test cases follow. Each test case consists of 4 lines with 4 characters each, with each character being 'X', 'O', '.' or 'T' (quotes for clarity only). Each test case is followed by an empty line. 
Output
For each test case, output one line containing "Case #x: y", where x is the case number (starting from 1) and y is one of the statuses given above. Make sure to get the statuses exactly right. When you run your code on the sample input, it should create the sample output exactly, including the "Case #1: ", the capital letter "O" rather than the number "0", and so on. 
Limits
The game board provided will represent a valid state that was reached through play of the game Tic-Tac-Toe-Tomek as described above. 
Small dataset
1 ≤ T ≤ 10. 
Large dataset
1 ≤ T ≤ 1000. 
Sample

```
Input       Output 
6           Case #1: X won
XXXT        Case #2: Draw
....        Case #3: Game has not completed
OO..        Case #4: O won
....        Case #5: O won
            Case #6: O won
XOXT
XXOO
OXOX
XXOO

XOX.
OX..
....
....

OOXX
OXXX
OX.T
O..O

XXXO
..O.
.O..
T...

OXXX
XO..
..O.
...O
```
Note
Although your browser might not render an empty line after the last test case in the sample input, in a real input file there would be one.

# Gilded Rose Refactoring

## Introduction 
The Gilded Rose is a small inn with a prime location in a prominent city run by a friendly innkeeper named Allison. It buys and sells only the finest goods. Unfortunately, the goods are constantly degrading in quality as they approach their sell by date. We have a system in place that updates our inventory for us. It was developed by a no-nonsense type named Leeroy, who has moved on to new adventures. Your task is to add a new feature to our system so we can sell a new category of items.  First, an introduction to our system: 

## Current System Behavior 
• All items have a SellIn value which denotes the number of days we have to sell the item 
• All items have a Quality value which denotes how valuable the item is 
• At the end of each day our system lowers both values for every item 
• Once the sell by date has passed, Quality degrades twice as fast 
• The Quality of an item is never negative 
• “Aged Brie” actually increases in Quality the older it gets 
• The Quality of an item is never more than 50 
• “Sulfuras”, being a legendary item, never has to be sold or decreases in Quality 
• “Backstage passes”, like aged brie, increases in Quality as it’s SellIn value approaches; Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but Quality drops to 0 after the concert 

## New Requirements 
“Conjured” items degrade in Quality twice as fast as normal items

# Rental Movie
Get the code from github: https://sgithub.fr.world.socgen/AgileCenter/kata-rental-movie-java

The class Customer has a method statement() that returns a String. 

The business needs a new functionality: return a String in HTML format so that it can be inserted in our Web portal. 

# Prime Factors
## Introduction 
The prime factors kata is a math-based kata in which we write a method which will break down any number into a list of its prime factors. This means that we return the set of one or more prime numbers that when multiplied together will give us the initial number. 
## Requirements 
Write a class named "PrimeFactors" that has one static method: generate. 

* The generate method takes an integer argument and returns a collection of integers. That list contains the prime factors in numerical sequence. 

## Examples 
• generate(2) = [2] 
• generate(3) = [3] 
• generate(4) = [2,2] 
• generate(6) = [2,3] 
• generate(8) = [2,2,2] 
• generate(9) = [3,3] 
• generate(10)=[2,5] 
• generate(12)= [2,2,3] 

# Potter

Once upon a time there was a series of 5 books about a very English hero called Harry. (At least when this Kata was invented, there were only 5. Since then they have multiplied)
Children all over the world thought he was fantastic, and, of course, so did the publisher. So in a gesture of immense generosity to mankind, (and to increase sales) they set up the following pricing model to take advantage of Harry’s magical powers.

One copy of any of the five books costs 8 EUR. If, however, you buy two different books from the series, you get a 5% discount on those two books. If you buy 3 different books, you get a 10% discount. With 4 different books, you get a 20% discount. If you go the whole hog, and buy all 5, you get a huge 25% discount.
Note that if you buy, say, four books, of which 3 are different titles, you get a 10% discount on the 3 that form part of a set, but the fourth book still costs 8 EUR.

Potter mania is sweeping the country and parents of teenagers everywhere are queuing up with shopping baskets overflowing with Potter books. Your mission is to write a piece of code to calculate the price of any conceivable shopping basket, giving as big a discount as possible.

For example, how much does this basket of books cost?

• 2 copies of the first book
• 2 copies of the second book
• 2 copies of the third book
• 1 copy of the fourth book
• 1 copy of the fifth book
Answer: 51.20 EUR

# Diamond Kata

Given a letter, print a diamond starting with ‘A’ with the supplied letter at the widest point.

For example: print-diamond "C" prints

      A
     B B
    C   C
     B B
      A

