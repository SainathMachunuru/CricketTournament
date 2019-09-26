package com.everest.cricket.game;

import java.util.List;

import com.everest.cricket.player.Player;

public interface GameServiceDef {
	public void checkForWinAndDisplayResult(int noOfRunsRequired, int noOfBallsLeft, int wickets);

	public boolean isOverCompleted(int noOfBalls);

	public void changeStrike(Crease crease, Player player);

	public void displayComment(Player player, int score, int overNumber, int ballsOfOver);

	public void displayOverEndComment();

	public void displayFinalScoreBoard(List<Player> players);

	public void displayWelcomeCommand();

	public void displayMatchEquation(int noOfOVersLeft, int noOfRunsRequired);

}
