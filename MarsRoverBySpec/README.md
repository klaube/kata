Mars Rover
===========

Java Code Kata

Prepared for the [Softwerkskammer Magdeburg Treffen 44 @ IBM] 
(https://www.softwerkskammer.org/activities/magdeburg_treffen_44/)

Taken from [Technology Conversations] (https://technologyconversations.com/2014/10/17/java-tutorial-through-katas-mars-rover/)

Runs with *JUnit 4.12* and *hamcrest 1.3* as testing framework.


**Your Task**

Develop an api that moves a rover around on a grid.

You are given the initial starting point (x,y) of a rover and the direction (N,S,E,W) it is facing.

- The rover receives a character array of commands.<br />
- Implement commands that move the rover forward/backward (f,b).<br />
- Implement commands that turn the rover left/right (l,r).<br />
- Implement wrapping from one edge of the grid to another. (planets are spheres after all)<br />
- Implement obstacle detection before each move to a new square.<br />

If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point and reports the obstacle.
