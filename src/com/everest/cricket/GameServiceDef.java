package com.everest.cricket;

public interface GameServiceDef {
	public boolean checkForWin();
	public boolean isOverCompleted(int noOfBalls);
	public void changeStrike(Crease crease,Player player);
	public void displayComment(Player player,int score);
	public void displayComment();

}
