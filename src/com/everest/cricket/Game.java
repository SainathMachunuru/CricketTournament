package com.everest.cricket;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Game {
	private static final List<Player> playersList = new ArrayList<>();
	private static Crease crease;
	private static Player currentPlayer;

	public static void main(String[] args) {
		intialGameLoad();
		startGame();
	}

	private static void intialGameLoad() {
		playersList.add(new Player("Kirat Boli", PlayerEnum.KIRAT_BOILI.buildPlayerScoreProbabilityMap()));
		playersList.add(new Player("N.S Nodhi", PlayerEnum.NS_NODHI.buildPlayerScoreProbabilityMap()));
		playersList.add(new Player("R Rumrah", PlayerEnum.R_RUMRAH.buildPlayerScoreProbabilityMap()));
		playersList.add(new Player("Shashi Henra", PlayerEnum.SHASHI_HENRA.buildPlayerScoreProbabilityMap()));
		
		crease = new Crease(playersList.get(0),playersList.get(1) );
		
		
		
		
	
	 
		

	}

	private static void startGame() {
		int noOfRunsScored = GameConstants.NO_OF_RUNS_REQUIRED,noOfBallsLeft = GameConstants.NO_OF_BALLS_left;
		int currentBalls,currentRuns;
		while(noOfRunsScored>0 && noOfBallsLeft>0){
			currentPlayer =crease.getStriker();
			int score = currentPlayer.play();
			if(score == 2 || score == 4 || score == 6 || score  == 0){
				System.out.println(currentPlayer.getName()+" scores "+score+" runs");
				noOfRunsScored-=score;
				noOfBallsLeft--;
				currentBalls = currentPlayer.getBalls()+1;
				currentRuns = currentPlayer.getRuns()+score;
				currentPlayer.setBalls(currentBalls);
				currentPlayer.setRuns(currentRuns);
				
			}
			else if(score == 1 || score == 3 || score == 5){
				System.out.println(currentPlayer.getName()+" scores "+score+" runs");
				noOfRunsScored-=score;
				noOfBallsLeft--;
				currentBalls = currentPlayer.getBalls()+1;
				currentRuns = currentPlayer.getRuns()+score;
				currentPlayer.setBalls(currentBalls);
				currentPlayer.setRuns(currentRuns);
				crease.setStriker(crease.getNonStriker());
				crease.setNonStriker(currentPlayer);;
				
			}
			else{
				System.out.println(currentPlayer.getName()+" got out");
				noOfBallsLeft--;
				
			}
			
			
			
			
		}

	}

}
