package com.example.tictactoe.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.tictactoe.pojo.Player;

/*
 * This Player test class contains test cases for setting player details and getting player details 
 */
@SpringBootTest
class PlayerServiceTest {
  
    @Autowired
	private PlayerService playerService;

	List<Player> players;
	
	@BeforeEach
	void setup() {
		players = new ArrayList<>(2);
        players.add(new Player("X", "Player 1"));
        players.add(new Player("O", "Player 2"));
	}

	/*
	 * This test case to get all Player Details
	 */
	@Test
	void testGetPlayers() {
		playerService.players = players;
		assertEquals(players, playerService.getPlayers());
	}

	/*
	 * This test case to get Player Details
	 */
	@Test
	void testGetPlayerDetails() {
		assertEquals(new Player("X", "Player 1"), playerService.getPlayer("X"));
	}
	
	
	/*
	 * This test case to get Invalid Player Details
	 */
	@Test
	void testGetInvalidPlayerDetails() {
		assertEquals(null, playerService.getPlayer("S"));
	}
}
