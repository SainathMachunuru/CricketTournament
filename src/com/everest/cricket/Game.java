package com.everest.cricket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Game {
	private static final List<Player> playersList = new ArrayList<>();
	private static Crease crease;
	private static Player currentPlayer;
	private static GameService gameService = new GameService();

	public static void main(String[] args) {
		intialGameLoad();
		startGame();
	}

	private static void intialGameLoad() {
		playersList.add(new Player("Kirat Boli", PlayerEnum.KIRAT_BOILI
				.buildPlayerScoreProbabilityMap()));
		playersList.add(new Player("N.S Nodhi", PlayerEnum.NS_NODHI
				.buildPlayerScoreProbabilityMap()));
		playersList.add(new Player("R Rumrah", PlayerEnum.R_RUMRAH
				.buildPlayerScoreProbabilityMap()));
		playersList.add(new Player("Shashi Henra", PlayerEnum.SHASHI_HENRA
				.buildPlayerScoreProbabilityMap()));

		crease = new Crease(playersList.get(0), playersList.get(1));
		playersList.get(0).isToYetBat = false;
		playersList.get(1).isToYetBat = false;

	}

	private static void startGame() {
		int noOfRunsRequired = GameConstants.NO_OF_RUNS_REQUIRED, noOfBallsLeft = GameConstants.NO_OF_BALLS_left;
		int playerIndex = 2;
		int wickets = 0;
		gameService.displayWelcomeCommand();
		while (noOfRunsRequired > 0 && noOfBallsLeft > 0 && wickets<GameConstants.NO_OF_WICKETS) {
			currentPlayer = crease.getStriker();
			int score = currentPlayer.play();
			if (score == 2 || score == 4 || score == 6 || score == 0) {
				System.out.println(currentPlayer.getName() + " scores " + score
						+ " runs");
				noOfRunsRequired -= score;
				--noOfBallsLeft;
				currentPlayer.updateScoreCard(score);
				if (gameService.isOverCompleted(noOfBallsLeft)) {
					gameService.changeStrike(crease, currentPlayer);
					gameService.displayComment();

				}

			} else if (score == 1 || score == 3 || score == 5) {
				System.out.println(currentPlayer.getName() + " scores " + score
						+ " runs");
				noOfRunsRequired -= score;
				--noOfBallsLeft;
				currentPlayer.updateScoreCard(score);
				gameService.changeStrike(crease, currentPlayer);
				if (gameService.isOverCompleted(noOfBallsLeft)) {
					currentPlayer = crease.getStriker();
					gameService.changeStrike(crease, currentPlayer);
					gameService.displayComment();

				}

			} else {
				System.out.println(currentPlayer.getName() + " got out");
				--noOfBallsLeft;
				++wickets;
				currentPlayer.isOut = true;
				if(wickets<GameConstants.NO_OF_WICKETS) {
					crease.setStriker(playersList.get(playerIndex));
					currentPlayer = crease.getStriker();
					currentPlayer.isToYetBat = false;
					playerIndex++;
				}
				else {
					break;
				}
				if (gameService.isOverCompleted(noOfBallsLeft)) {
					gameService.changeStrike(crease, currentPlayer);
					gameService.displayComment();

				}
				

			}

		}
		System.out.println("\n****** MATCH SUMMARAY ***************");
		if(gameService.checkForWin(noOfRunsRequired)){
			gameService.displayWinComment(noOfRunsRequired, noOfBallsLeft, wickets);
		}
		else {
			gameService.displayLossComment(noOfRunsRequired);
		}
		System.out.println("****** FINAL SCORE BOARD ***************");
		gameService.displayFinalScoreBoard(playersList);
		

	}

}
