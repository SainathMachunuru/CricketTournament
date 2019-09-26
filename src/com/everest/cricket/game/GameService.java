package com.everest.cricket.game;

import java.util.List;
import com.everest.cricket.player.Player;


/**
 * 
 * @author msainath
 * Description: This is the Service Class,will perform some game related activities
 */
public class GameService implements GameServiceDef {
	/*
	 * This method checks for game winning scenario.it will give true if no more
	 * runs required to win otherwise gives false;
	 */
	@Override
	public void checkForWinAndDisplayResult(int noOfRunsRequired, int noOfBallsLeft, int wickets) {
		if(noOfRunsRequired<=0) {
			displayWinComment(noOfRunsRequired, noOfBallsLeft, wickets);
			
		}
		else if(noOfRunsRequired == 1) {
			displayDrawComment();
		}
		else {
			displayLossComment(noOfRunsRequired);
		}

	}

	// this method checks for over completion case.
	@Override
	public boolean isOverCompleted(int noOfBalls) {
		return noOfBalls % 6 == 0 ? true : false;

	}

	// This method used to displays ball by ball commentary
	@Override
	public void displayComment(Player player, int score, int overNumber, int ballsOfOver) {
		if (score == -1) {
			System.out.println(overNumber + "." + ballsOfOver + " " + player.getName() + " got out");

		} else {
			System.out.println(overNumber + "." + ballsOfOver + " " + player.getName() + " scores " + score + " runs");
		}

	}

	// This method used to change the strike of players(striker and non-striker)
	@Override
	public void changeStrike(Crease crease, Player player) {
		crease.setStriker(crease.getNonStriker());
		crease.setNonStriker(player);
		;

	}

	// This method used display over break comment
	@Override
	public void displayOverEndComment() {
		System.out.println("************ OVER BREAK ***************\n");

	}


	// This method used to display final score board
	@Override
	public void displayFinalScoreBoard(List<Player> players) {
		for (int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			if (!player.isToYetBat) {
				StringBuilder palyerSummaray = new StringBuilder();
				String notOut = player.isOut ? "" : "*";
				palyerSummaray.append(player.getName()).append(" - ").append(player.getRuns()).append(notOut)
						.append(" (").append(player.getBalls()).append(")");
				System.out.println(palyerSummaray.toString());

			}

		}

	}

	// This method used to display welcome comment for match
	@Override
	public void displayWelcomeCommand() {
		System.out.println("@@@@@@@@@@ FINAL T20 MATCH BENGALURU VS CHENNAI @@@@@@@@@@@\n");

	}

	// This method used to display match equation at the end of every over
	@Override
	public void displayMatchEquation(int noOfOVersLeft, int noOfRunsRequired) {
		System.out.println(noOfOVersLeft + " overs left " + noOfRunsRequired + " runs to win");

	}
	// This method used to display over winning case comment
	private void displayWinComment(int noOfRunsRequired, int noOfBallsLeft, int wickets) {
		System.out.println(GameConstants.TEAM_NAME + " won by " + (GameConstants.NO_OF_WICKETS - wickets)
				+ " wickets and " + noOfBallsLeft + " balls remaining\n");

	}

	// This method used to display game losing case comment
	private void displayLossComment(int noOfRunsRequired) {
		System.out.println(GameConstants.TEAM_NAME + " lost by " + (noOfRunsRequired-1) + " runs\n");
	}
	// This method used to display over draw case comment
		private void displayDrawComment() {
			System.out.println("The Match was TIE");
		}

}
