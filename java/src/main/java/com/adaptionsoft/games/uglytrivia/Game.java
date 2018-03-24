package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;

public class Game {
    private final IPrinter printer;
    private final GameState gameState;

    private final QuestionDeck questionDeck = new QuestionDeck();

    ArrayList<String> players = new ArrayList<>();
    int[] places = new int[6];
    //int[] purses = new int[6];
    boolean[] inPenaltyBox = new boolean[6];

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public Game(IPrinter printer, GameState gameState) {
        this.printer = printer;
        this.gameState = gameState;
    }

    public String createQuestion(Category type, int index) {
        return type + " Question " + index;
    }

    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    public boolean add(String playerName) {


        players.add(playerName);
        places[howManyPlayers()] = 0;
        //purses[howManyPlayers()] = 0;
        inPenaltyBox[howManyPlayers()] = false;

        printer.print(playerName + " was added");
        printer.print("They are player number " + players.size());
        return true;
    }

    public int howManyPlayers() {
        return players.size();
    }

    public void roll(int roll) {
        printer.print(players.get(currentPlayer) + " is the current player");
        printer.print("They have rolled a " + roll);

        if (inPenaltyBox[currentPlayer]) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                printer.print(players.get(currentPlayer) + " is getting out of the penalty box");
                moveCurrentPlayer(roll);

                printer.print(players.get(currentPlayer)
                        + "'s new location is "
                        + places[currentPlayer]);
                printer.print("The category is " + currentCategory());
                askQuestion();
            } else {
                printer.print(players.get(currentPlayer) + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {

            moveCurrentPlayer(roll);

            printer.print(players.get(currentPlayer)
                    + "'s new location is "
                    + places[currentPlayer]);
            printer.print("The category is " + currentCategory());
            askQuestion();
        }

    }

    private void moveCurrentPlayer(int roll) {
        places[currentPlayer] = places[currentPlayer] + roll;
        if (places[currentPlayer] >= Board.NUMBER_OF_FIELDS) {
            places[currentPlayer] = places[currentPlayer] - Board.NUMBER_OF_FIELDS;
        }
    }

    private void askQuestion() {
        String question = questionDeck.getQuestion(currentCategory());
        printer.print(question);
    }


    private Category currentCategory() {
        return new Board().getCategoryForField(places[currentPlayer]);
    }

    public boolean wasCorrectlyAnswered() {
        if (inPenaltyBox[currentPlayer]) {
            if (isGettingOutOfPenaltyBox) {
                return playerAnswersCorrectly();
            } else {
                nextPlayer();
                return true;
            }
        } else {
            return playerAnswersCorrectly();
        }
    }

    private boolean playerAnswersCorrectly() {
        printer.print("Answer was correct!!!!");
        String player = players.get(currentPlayer);
        gameState.giveGoldCoinToPlayer(player);
        //purses[currentPlayer]++;
        printer.print(players.get(currentPlayer)
                + " now has "
                + gameState.getPlayerCoins(player)
                + " Gold Coins.");

        boolean shouldContinue = shouldContinue();
        nextPlayer();

        return shouldContinue;
    }

    private void nextPlayer() {
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
    }

    public boolean wrongAnswer() {
        printer.print("Question was incorrectly answered");
        printer.print(players.get(currentPlayer) + " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;

        nextPlayer();
        return true;
    }

    private boolean shouldContinue() {
        String player = players.get(currentPlayer);
        return !(gameState.getPlayerCoins(player) == 6);
    }
}
