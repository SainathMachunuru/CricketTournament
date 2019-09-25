package com.everest.cricket.game;

import java.util.List;

import com.everest.cricket.player.Player;

public interface GameServiceDef {
	public boolean checkForWin(int noOfRunsRequired);

	public boolean isOverCompleted(int noOfBalls);

	public void changeStrike(Crease crease, Player player);

	public void displayComment(Player player, int score, int overNumber, int ballsOfOver);

	public void displayComment();

	public void displayWinComment(int noOfRunsRequired, int noOfBallsLeft, int wickets);

	public void displayLossComment(int noOfRunsRequired);

	public void displayFinalScoreBoard(List<Player> players);

	public void displayWelcomeCommand();

	public void displayMatchEquation(int noOfOVersLeft, int noOfRunsRequired);

}
