package com.everest.cricket.game;

import java.util.ArrayList;
import java.util.List;

import com.everest.cricket.player.Player;
import com.everest.cricket.player.PlayerEnum;
import com.everest.cricket.player.PlayerService;

public class Game {
	private static final List<Player> playersList = new ArrayList<>();
	private static Crease crease;
	private static Player currentPlayer;
	private static GameService gameService = new GameService();
	private static PlayerService playerService = new PlayerService();

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
	
	
	 //This method will display whether team won or lost by using target conditions
	private static void startGame() {
		int noOfRunsRequired = GameConstants.NO_OF_RUNS_REQUIRED, noOfBallsLeft = GameConstants.NO_OF_BALLS_left;
		int playerIndex = 2, wickets = 0, ballsOfOver = 0, overNumber = 0,noOfOversLeft = GameConstants.NO_OF_OVERS_LEFT;
		gameService.displayWelcomeCommand();
		gameService.displayMatchEquation(noOfOversLeft, noOfRunsRequired);

		while (noOfRunsRequired > 0 && noOfBallsLeft > 0 && wickets < GameConstants.NO_OF_WICKETS) {
			currentPlayer = crease.getStriker();
			int score = playerService.play(currentPlayer);
			++ballsOfOver;
			--noOfBallsLeft;
			if (score == 2 || score == 4 || score == 6 || score == 0) {
				noOfRunsRequired -= score;
				gameService.displayComment(currentPlayer, score, overNumber, ballsOfOver);
				playerService.updateScoreCard(score,currentPlayer);
				if (gameService.isOverCompleted(noOfBallsLeft)) {
					gameService.changeStrike(crease, currentPlayer);
					gameService.displayComment();
					++overNumber;
					ballsOfOver = 0;
					--noOfOversLeft;
					gameService.displayMatchEquation(noOfOversLeft, noOfRunsRequired);

				}

			} else if (score == 1 || score == 3 || score == 5) {
				noOfRunsRequired -= score;
				gameService.displayComment(currentPlayer, score, overNumber, ballsOfOver);
				playerService.updateScoreCard(score,currentPlayer);
				gameService.changeStrike(crease, currentPlayer);
				if (gameService.isOverCompleted(noOfBallsLeft)) {
					currentPlayer = crease.getStriker();
					gameService.changeStrike(crease, currentPlayer);
					gameService.displayComment();
					++overNumber;
					ballsOfOver = 0;
					--noOfOversLeft;
					gameService.displayMatchEquation(noOfOversLeft, noOfRunsRequired);

				}

			} else {
				gameService.displayComment(currentPlayer, score, overNumber, ballsOfOver);
				++wickets;
				currentPlayer.isOut = true;
				if (wickets < GameConstants.NO_OF_WICKETS) {
					crease.setStriker(playersList.get(playerIndex));
					currentPlayer = crease.getStriker();
					currentPlayer.isToYetBat = false;
					playerIndex++;
				}
				if (gameService.isOverCompleted(noOfBallsLeft)) {
					gameService.changeStrike(crease, currentPlayer);
					gameService.displayComment();
					++overNumber;
					ballsOfOver = 0;
					--noOfOversLeft;
					gameService.displayMatchEquation(noOfOversLeft, noOfRunsRequired);

				}

			}

		}
		System.out.println("\n****** MATCH SUMMARAY ***************");
		if (gameService.checkForWin(noOfRunsRequired)) {
			gameService.displayWinComment(noOfRunsRequired, noOfBallsLeft, wickets);
		} else {
			gameService.displayLossComment(noOfRunsRequired);
		}
		System.out.println("****** FINAL SCORE BOARD ***************");
		gameService.displayFinalScoreBoard(playersList);

	}

}
