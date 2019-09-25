package com.everest.cricket;

import java.util.List;

public interface GameServiceDef {
	public boolean checkForWin(int noOfRunsRequired);
	public boolean isOverCompleted(int noOfBalls);
	public void changeStrike(Crease crease,Player player);
	public void displayComment(Player player,int score);
	public void displayComment();
	public void displayWinComment(int noOfRunsRequired, int noOfBallsLeft, int wickets);
	public void displayLossComment(int noOfRunsRequired);
	public void displayFinalScoreBoard(List<Player> players);
	public void displayWelcomeCommand();

}
