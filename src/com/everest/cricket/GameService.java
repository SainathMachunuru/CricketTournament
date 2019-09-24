package com.everest.cricket;

public class GameService implements GameServiceDef {

	@Override
	public boolean checkForWin() {
		return false;
	}

	@Override
	public boolean isOverCompleted(int noOfBalls) {
		return noOfBalls%6 == 0 ? true : false;

	}

	@Override
	public void displayComment(Player player, int score) {
		System.out.println(player.getName()+" scores "+score+" runs");
	}

	@Override
	public void changeStrike(Crease crease, Player player) {
		crease.setStriker(crease.getNonStriker());
		crease.setNonStriker(player);;
		
	}

	@Override
	public void displayComment() {
		System.out.println("************ OVERR BREAK ***************");
		
		
	}



}
