# One Two
We need to convert a string of numbers in another written with letters that describe the first like the Conway sequence.

## Examples 

    1        => one one
    12       => one one one two
    1121     => two one one two one one
    111556   => three one two five one six
    11556622 => two one two five two six two two
        
# Second step      

We then need to do the opposite

    one one            => 1
    two three          => 33
    one two three four => 2444
    
# No more than nine

Then we realize that it would be too complicated to handle more than 9 numbers. So we decide to add this simplification rule

    111111111111 => nine one three one
    
and of course is should also work in the other way 

    nine two one two => 2222222222
    