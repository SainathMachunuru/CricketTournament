package com.everest.cricket;

import java.util.Map;

public class Player {
	private String name;
	private int runs;
	private int balls;
	private Map<Integer, Integer> gameProbability;
	public boolean isOut;
	public boolean isOnStrike;

	public Player(String name, Map<Integer, Integer> gameProbability) {
		this.name = name;
		this.gameProbability = gameProbability;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getBalls() {
		return balls;
	}

	public void setBalls(int balls) {
		this.balls = balls;
	}

	public Map<Integer, Integer> getGameProbability() {
		return gameProbability;
	}

	public void setGameProbability(Map<Integer, Integer> gameProbability) {
		this.gameProbability = gameProbability;
	}

}
