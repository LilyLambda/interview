# Interview Questions #

I've answered questions in Java mostly because it's the industry lingua franca
and the language of most interviews. I'm more proficient developing Scala, and
perfectly at home scripting in Ruby & Python.

## Build ##

The solutions are packaged in a Docker container to ensure portability.

    cd interview
    docker build -t interview .

Note: if you do not wish to use Docker, you can run the the gradlew commands
below on a machine that has Java 8 installed.

## Run ##

    docker run interview ./gradlew run

## Question 4 ##
If we can assume the only characters are '(' and ')' it's possible to simplify
the code from Question 3. It's no longer necessary to track the type of the
character going into the stack. In fact, no stack at all is necessary. An integer
counter is all we need to keep track of whether the number of close parentheses
match the number of open parentheses. The check for stack emptiness (performed
every time we reach a close paren) can be replaced with a check if the integer
counter is greater than zero.
