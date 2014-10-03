###Elephant Carpaccio

Java Code by Arnim H.-Schneider und Katharina Laube

Written during and finished after the [Softwerkskammer Meeting @ leanovate] 
(http://www.meetup.com/Software-Craftsmanship-Berlin/events/197712012/)

Runs with *JUnit 4.11*, *hamcrest 1.3* and *JUnitParams 1.0.3* as testing framework.

**Business Requirements**

Accept 3 inputs from the user:
- How many items
- Price per item
- 2-letter state code

Output the total price. Give a discount based on the total price, add state tax based on the state and the discount price.

Order value --> discount rate: 1000 € --> 3% | 5000 € --> 5% | 7000 € --> 7% | 10000 € --> 10% | 50000 € --> 15%

State --> Tax rate: DE --> 19 % | DK --> 25% | HR --> 25% | IS --> 25,5% | CH --> 8%

Run *CaculatorTest* to see our user stories.

**Motivation of Elephant Crpaccio**

Most programmers say they dodn’t know how to slice feature requests to the hour level. In contrast, top programmers easily take them to 15-30 minute programming episodes. What does it take for people to make the transition?

This exercise has turned out to be so successful in helping people get to nano-incremental development that I teach it everywhere, to business analysts (partnered with a programmer), and to programmers (partnered together) – and I encourage people in my sessions to take it back and do it back in their companies. I suspect the discussion before and the debriefing after make some difference, but the true learning is the actual programming section.

**Learning outcomes**

- How to slice large applications into 1-day to 1-week requests, from the business perspective
- How to slice application requests into 15-30 minute work slices, from both the business and programming perspective
- What carpaccio is (have you already learned that while browsing this page?)

**Process/Mechanics**

- Break into teams of 2-3 people, at least one programmer per team.
- Discuss elephants, flank steaks, sashimi, carpaccio, as needed. (see Elephant carpaccio (discussion: Re: Elephant carpaccio) and  Design as Knowledge Acquisition (discussion: Re: Trim the Tail)).
- Present assignment.
- For 15 minutes, have the teams cut the assignment into 8-18 user stories or feature requests, estimated to be programmable at 3-8 minutes each, each a potentially demo-able end-of-sprint result (no UI mockups, no data tables, no showing code, etc.).
- Discuss, correct, argue, harangue, until the participants understand what’s needed of these slices.
- Run Five 7- to 10-minute programming sprints. At the end of each sprint, ring a bell or similar, each team shows its latest program running to another team. Clock does not stop between iterations, demos cost programming time. (Yes, truly, teams have done this successfully with /7/ minute iterations!)
- Debrief. Use the Design as Knowledge Acquisition (discussion: Re: Trim the Tail) graphs.

see also [Elephant Carpaccio Excercise] (http://alistair.cockburn.us/Elephant+Carpaccio+exercise)
