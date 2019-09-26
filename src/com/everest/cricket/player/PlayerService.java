package com.everest.cricket.player;

import com.everest.cricket.utility.Util;

/**
 * 
 * @author msainath
 *  description: This is the service class which allow us to do some player related activities for every individual player.
 *
 */

public class PlayerService implements PlayerServiceDef {
	/*
	 * This method take particular player as argument and get some random score
	 * based on player score-probability
	 */
	@Override
	public int play(Player player) {
		int size = player.getGameProbability().keySet().size();
		int[] scores = new int[size];
		int[] probabilities = new int[size];
		int i = 0;
		for (int key : player.getGameProbability().keySet()) {
			scores[i] = key;
			probabilities[i] = player.getGameProbability().get(key);
			i++;
		}
		return Util.getRandomScore(scores, probabilities);

	}
	/*
	 * This method take particular player and score as arguments and update player
	 * score-card(runs and balls)
	 */

	public void updateScoreCard(int score, Player player) {
		int currentBalls = player.getBalls() + 1;
		int currentRuns = player.getRuns();
		if (score != -1) {
			currentRuns += score;
		}

		player.setBalls(currentBalls);
		player.setRuns(currentRuns);

	}

}
