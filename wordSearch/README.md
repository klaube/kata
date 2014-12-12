###Word Search Kata

Java Code by Till Friebe and Katharina Laube

Written during and finished after the [December Coding Dojo of Berlin Agile Developers @ E-Post] 
(http://www.meetup.com/Agile-Developers-Berlin/events/218984210/)

Runs with *JUnit 4.11* as testing framework.

**Business Requirements**

This time is the goal to find the right words in a bunch of letters. “Wordpuzzle” is the blueprint for this Coding Dojo. The words can be found in a horizontal way as well as vertical or diagonal. And the words can be read in a normal way or backwards.

If someone is interested to play the game before, please have a look into Google Play Store. Apple should also have a game like this:
[WordSearch App] (https://play.google.com/store/apps/details?id=com.melimots.WordSearch&hl=en)

The index of the matrix in count from the upper left corner with 0 and ends in the lower right corner with x*y-1. The position of start and end within the matrix should be provided when the word was found to highlight the letters.