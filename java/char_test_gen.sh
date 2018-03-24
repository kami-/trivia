#!/bin/bash
# Basic while loop

fixtures_dir='src/test/java/resources/fixtures'

mkdir -p $fixtures_dir

counter=0
limit=999
while [ $counter -le $limit ]
do
  java -cp target/uglytrivia-1.0-SNAPSHOT.jar com.adaptionsoft.games.trivia.runner.GameRunner $counter > $fixtures_dir/$counter
  ((counter++))
done