package com.everest.cricket;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private static final List<Player> playersList = new ArrayList<>();

	public static void main(String[] args) {
		intialGameLoad();
		startGame();
	}

	private static void intialGameLoad() {
		playersList.add(new Player("Kirat Boli", PlayerEnum.KIRAT_BOILI.buildPlayerScoreProbabilityMap()));
		playersList.add(new Player("N.S Nodhi", PlayerEnum.NS_NODHI.buildPlayerScoreProbabilityMap()));
		playersList.add(new Player("R Rumrah", PlayerEnum.R_RUMRAH.buildPlayerScoreProbabilityMap()));
		playersList.add(new Player("Shashi Henra", PlayerEnum.SHASHI_HENRA.buildPlayerScoreProbabilityMap()));

	}

	private static void startGame() {

	}

}
