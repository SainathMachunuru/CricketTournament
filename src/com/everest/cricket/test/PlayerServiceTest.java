package com.everest.cricket.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.everest.cricket.player.Player;
import com.everest.cricket.player.PlayerEnum;
import com.everest.cricket.player.PlayerService;

public class PlayerServiceTest {
	@InjectMocks
	PlayerService playerService;
	
	@Before
    public void setUp() throws Exception {
         MockitoAnnotations.initMocks(this);
    }
	@Test
	public void shouldTestPlay(){
		Player player = new Player("Kirat Boli", PlayerEnum.KIRAT_BOILI.buildPlayerScoreProbabilityMap());
		int score = playerService.play(player);
		assertNotNull(score);
		assertTrue(PlayerEnum.KIRAT_BOILI.buildPlayerScoreProbabilityMap().keySet().contains(score));
		
	}
	@Test
	public void shouldUpdatePlayerScoreCard(){
		Player player = new Player("Kirat Boli", PlayerEnum.KIRAT_BOILI.buildPlayerScoreProbabilityMap());
		player.setRuns(10);
		player.setBalls(5);
		playerService.updateScoreCard(6, player);
		assertEquals(16, player.getRuns());
		assertEquals(6, player.getBalls());
		
		
	}

}
