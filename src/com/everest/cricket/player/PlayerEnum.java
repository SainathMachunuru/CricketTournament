package com.everest.cricket.player;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author msainath
 *	description: This is the enum to define every player's score-probability cases.
 */
public enum PlayerEnum {

	KIRAT_BOILI(5, 30, 25, 10, 15, 1, 9, 5), 
	NS_NODHI(10, 40, 20, 5, 10, 1, 4, 10), 
	R_RUMRAH(20, 30, 15, 5, 5, 1, 4,20),
	SHASHI_HENRA(30, 25, 5, 0, 5, 1, 4, 30);

	private int dotProbability;
	private int oneRunProbability;
	private int twoRunProbability;
	private int threeRunProbability;
	private int fourRunProbability;
	private int fiveRunProbability;
	private int sixRunProbability;
	private int outProbability;

	private PlayerEnum(int dotProb, int oneRunProb, int twoRunProb, int threeRunProb, int fourRunProb, int fiveRunProb,
			int sixRunProb, int outProb) {
		this.dotProbability = dotProb;
		this.oneRunProbability = oneRunProb;
		this.twoRunProbability = twoRunProb;
		this.threeRunProbability = threeRunProb;
		this.fourRunProbability = fourRunProb;
		this.fiveRunProbability = fiveRunProb;
		this.sixRunProbability = sixRunProb;
		this.outProbability = outProb;

	}

	public int getDotProbability() {
		return dotProbability;
	}

	public int getOneRunProbability() {
		return oneRunProbability;
	}

	public int getTwoRunProbability() {
		return twoRunProbability;
	}

	public int getThreeRunProbability() {
		return threeRunProbability;
	}

	public int getFourRunProbability() {
		return fourRunProbability;
	}

	public int getFiveRunProbability() {
		return fiveRunProbability;
	}

	public int getSixRunProbability() {
		return sixRunProbability;
	}

	public int getOutProbability() {
		return outProbability;
	}

	public Map<Integer, Integer> buildPlayerScoreProbabilityMap() {

		Map<Integer, Integer> probMap = new HashMap<>();

		probMap.put(0, this.getDotProbability());
		probMap.put(1, this.getOneRunProbability());
		probMap.put(2, this.getTwoRunProbability());
		probMap.put(3, this.getThreeRunProbability());
		probMap.put(4, this.getFourRunProbability());
		probMap.put(5, this.getFiveRunProbability());
		probMap.put(6, this.getSixRunProbability());
		probMap.put(-1, this.getOutProbability()); // -1 indicates OUT

		return probMap;

	}

}
