 # **CricketTournament Final Game App**

## Environment Setup
Make sure below things avialable before running this app
- Java 8
- Eclipse IDE(you can use any other also)
- Maven for junit and mockito

## How to run?
Game.java is bootstrap file for this application.you can run that as "run as java application" as it is stand-alone app.
if you have any problem with maven dependencies for running junit test cases you can still run main program without test cases.

## About Application.
This app  will  decide whether the team  will win the match based equation(target runs,overs left,wickets left).
player has a different probability for scoring runs.it will  simulate the match,ball by ball. 
The match simulation will  use a weighted random number generation based on probability to determine the runs scored per ball.

Rules of the game:
- Batsmen change strike end of every over. They also change strike when they score a 1,3 or 5
- When a player gets out, the new player comes in at the same position.
- Assume only legal balls are bowled (no wides, no no-balls etc..). Therefore an over is always 6 balls.
