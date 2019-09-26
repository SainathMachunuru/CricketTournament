package com.everest.cricket.game;

import java.util.ArrayList;
import java.util.List;

import com.everest.cricket.player.Player;
import com.everest.cricket.player.PlayerEnum;
import com.everest.cricket.player.PlayerService;

/**
 * 
 * @author msainath This is the bootstrap class for this game application
 */
public class Game {
	private static final List<Player> playersList = new ArrayList<>();
	private static Crease crease;
	private static Player currentPlayer;
	private static GameService gameService = new GameService();
	private static PlayerService playerService = new PlayerService();
	private static int noOfRunsRequired = GameConstants.NO_OF_RUNS_REQUIRED,
			noOfBallsLeft = GameConstants.NO_OF_BALLS_left;
	private static int playerIndex = 2, wickets = 0, ballsOfOver = 0, overNumber = 0,
			noOfOversLeft = GameConstants.NO_OF_OVERS_LEFT;

	public static void main(String[] args) {
		intialGameLoad();
		startGame();

	}

	private static void intialGameLoad() {
		// adding available to players to list.
		playersList.add(new Player("Kirat Boli", PlayerEnum.KIRAT_BOILI.buildPlayerScoreProbabilityMap()));
		playersList.add(new Player("N.S Nodhi", PlayerEnum.NS_NODHI.buildPlayerScoreProbabilityMap()));
		playersList.add(new Player("R Rumrah", PlayerEnum.R_RUMRAH.buildPlayerScoreProbabilityMap()));
		playersList.add(new Player("Shashi Henra", PlayerEnum.SHASHI_HENRA.buildPlayerScoreProbabilityMap()));

		// adding opening/starting two players to crease
		crease = new Crease(playersList.get(0), playersList.get(1));
		playersList.get(0).isToYetBat = false;
		playersList.get(1).isToYetBat = false;

	}

	// This method will display whether team won or lost by using target conditions
	private static void startGame() {
		gameService.displayWelcomeCommand();
		gameService.displayMatchEquation(noOfOversLeft, noOfRunsRequired);

		while (noOfRunsRequired > 0 && noOfBallsLeft > 0 && wickets < GameConstants.NO_OF_WICKETS) {
			currentPlayer = crease.getStriker();
			int score = playerService.play(currentPlayer);
			++ballsOfOver;
			--noOfBallsLeft;

			switch (score % 2) {
			case 0: {
				noOfRunsRequired -= score;
				gameService.displayComment(currentPlayer, score, overNumber, ballsOfOver);
				playerService.updateScoreCard(score, currentPlayer);
				if (gameService.isOverCompleted(noOfBallsLeft)) {
					completeOverEndActivities(score);

				}
				break;
			}
			case 1: {
				noOfRunsRequired -= score;
				gameService.displayComment(currentPlayer, score, overNumber, ballsOfOver);
				playerService.updateScoreCard(score, currentPlayer);
				gameService.changeStrike(crease, currentPlayer);
				if (gameService.isOverCompleted(noOfBallsLeft)) {
					completeOverEndActivities(score);

				}
				break;

			}
			default: {
				gameService.displayComment(currentPlayer, score, overNumber, ballsOfOver);
				++wickets;
				playerService.updateScoreCard(score, currentPlayer);
				currentPlayer.isOut = true;
				addNewPlayerToCrease();

				if (gameService.isOverCompleted(noOfBallsLeft)) {
					completeOverEndActivities(score);

				}
			}

			}

		}
		System.out.println("\n****** MATCH SUMMARAY ***************");
		gameService.checkForWinAndDisplayResult(noOfRunsRequired, noOfBallsLeft, wickets);
		System.out.println("****** FINAL SCORE BOARD ***************");
		gameService.displayFinalScoreBoard(playersList);

	}

	private static void completeOverEndActivities(int score) {
		if (score % 2 == 1) {
			currentPlayer = crease.getStriker();
		}
		gameService.changeStrike(crease, currentPlayer);
		++overNumber;
		ballsOfOver = 0;
		--noOfOversLeft;
		gameService.displayOverEndComment();
		if (noOfRunsRequired > 0 && noOfBallsLeft > 0 && wickets < GameConstants.NO_OF_WICKETS) {
			gameService.displayMatchEquation(noOfOversLeft, noOfRunsRequired);
		}

	}

	private static void addNewPlayerToCrease() {
		if (wickets < GameConstants.NO_OF_WICKETS) {
			crease.setStriker(playersList.get(playerIndex));
			currentPlayer = crease.getStriker();
			currentPlayer.isToYetBat = false;
			playerIndex++;
		}

	}

}
