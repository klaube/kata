###Kanban Board

Java Code by Isabel Batista and Katharina Laube

Written during the [Agile Developer Meeting @ epost Berlin] 
(http://www.meetup.com/)

Runs with *JUnit 4.11* and *JUnitParams 1.0.4* as testing framework.

**Business Requirements**

* 4 columns (ToDo, WiP, Test, Done)
* WiP and Test has limits (4, 3)
* All tasks start in ToDo
* Task is pulled to the next right column
* Every task after ToDo has an owner
* higher level: task has a story
