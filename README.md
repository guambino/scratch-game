# scratch-game
Problem statement: You need to build a scratch game, that will generate a matrix (for example 3x3) from symbols(based on probabilities for each individual cell) and based on winning combintations user either will win or lost. User will place a bet with any amount which we call *betting amount* in this assignment

# build
mvn package

# Run
java -jar target/scratch-game-1.0.0-SNAPSHOT-jar-with-dependencies.jar

java -jar target/scratch-game-1.0.0-SNAPSHOT-jar-with-dependencies.jar --config C:\usr\local\workspaces\workspace-assessment\cyberspeed\config.json --betting-amount 100