package com.everest.cricket.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.everest.cricket.game.Crease;
import com.everest.cricket.game.GameService;
import com.everest.cricket.player.Player;
import com.everest.cricket.player.PlayerEnum;

public class GameServiceTest {
	@InjectMocks
	GameService gameService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldTestIsOverCompletedSuccess() {
		int noOfBalls = 12;
		assertTrue(gameService.isOverCompleted(noOfBalls));
	}

	@Test
	public void shouldTestIsOverCompletedFailure() {
		int noOfBalls = 10;
		assertFalse(gameService.isOverCompleted(noOfBalls));
	}

	@Test
	public void shouldChangeStrike() {
		Player player1 = new Player("Kirat Boli", PlayerEnum.KIRAT_BOILI.buildPlayerScoreProbabilityMap());
		Player player2 = new Player("N.S Nodhi", PlayerEnum.NS_NODHI.buildPlayerScoreProbabilityMap());
		Crease crease = new Crease(player1, player2);
		Player currentPlayer = player1;
		gameService.changeStrike(crease, currentPlayer);
		assertEquals(player2, crease.getStriker());
		assertEquals(player1, crease.getNonStriker());
		assertEquals("N.S Nodhi", crease.getStriker().getName());
		assertEquals("Kirat Boli", crease.getNonStriker().getName());
	}

}
