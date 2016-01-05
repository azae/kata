# Bowling game

    1 4 | 4 5 | 6 / | 5 / |   X | 0 1 | 7 / | 6 / |   X | 2 / 6 | 
    5   | 14  | 29  | 49  | 60  | 61  | 77  | 97  | 117 | 133   |

The game consists of 10 frames as show above. In each frame, the player has two opportunities to knock down 10 pins. The score for the frame is the total number of mins knocked down, plus bonuses for strikes and spares.

A spare is when the player knocks down all 10 pins in two tries. The bonus for that frame is the number of pins knocked down by the next roll. So in frame 3 above, the score is 10 (the total number knocked down, plus a bonus of 5 (The number of pins knocked down on the next roll)
  
A strike is when the player knocks down all pin on his first try. The bonus for that frame is the value of the next two balls rolled.

In the tenth frame, a player who rolls a spare or strike is allowed to roll the extra balls to complete the frame. However no more than three balls can be rolled in tenth frame.

# Requirements

write a class name Game tha has two methods :
- roll(pins : int) is called each time the player rolls a ball. The argument is the number of pins knocked down.
- score() : int it return the current score of the game.

# Step2

Make the toString they render game like as show above
