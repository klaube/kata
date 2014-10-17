###Kata for Event-Driven-Architecture (EDA)

Java Code by Katharina Laube

Written during and finished after the [XPDays 2014 @ Handwerkskammer Hamburg] 
(http://www.xpdays.de/2014/sessions/048-event-getriebene-programmierung-in-der-praxis.html) by Marco Emrich.

Runs with *JUnit 4.11* and *hamcrest 1.3* as testing framework and *Ticino core and static 0.3.2* as event framework.

**Business Requirements**

When a telephone number is called
- the call should be routed to the right city
- the calls of each city should be counted

**Constraints**
- no method communication, events only
- single event bus
- no central bus
