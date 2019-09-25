package com.everest.cricket;

import java.util.List;

public class GameService implements GameServiceDef {

	@Override
	public boolean checkForWin(int noOfRunsRequired) {
		return noOfRunsRequired<=0 ? true : false;
	
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
		System.out.println("************ OVERR BREAK ***************\n");
		
		
	}

	@Override
	public void displayWinComment(int noOfRunsRequired, int noOfBallsLeft, int wickets) {
		System.out.println(GameConstants.TEAM_NAME+" win by "+(GameConstants.NO_OF_WICKETS-wickets)+" wickets and "+noOfBallsLeft+" balls remaining\n");
		
	}

	@Override
	public void displayLossComment(int noOfRunsRequired) {
		System.out.println(GameConstants.TEAM_NAME+" lost by "+noOfRunsRequired+" runs\n");
	}

	@Override
	public void displayFinalScoreBoard(List<Player> players) {
		for (int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			if(!player.isToYetBat) {
				StringBuilder palyerSummaray = new StringBuilder();
				String notOut = player.isOut ? "" : "*";
				palyerSummaray.append(player.getName()).append(" - ").append(player.getRuns()).append(notOut).append(" (")
						.append(player.getBalls()).append(")");
				System.out.println(palyerSummaray.toString());
				
			}
			
			

		}

	}

	@Override
	public void displayWelcomeCommand() {
		System.out.println("@@@@@@@@@@ FINAL T20 MATCH BENGALURU VS CHENNAI @@@@@@@@@@@\n");
		
		
	}



}
