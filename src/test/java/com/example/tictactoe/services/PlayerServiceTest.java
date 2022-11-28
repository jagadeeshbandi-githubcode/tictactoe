package com.example.tictactoe.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.tictactoe.pojo.Player;

@SpringBootTest
public class PlayerServiceTest {
  
    @Autowired
	private PlayerService playerService;

	List<Player> players;
	
	@BeforeEach
	public void setup() {
		players = new ArrayList<>(2);
        players.add(new Player("X", "Player 1"));
        players.add(new Player("O", "Player 2"));
	}

	/*
	 * This test case to get all Player Details
	 */
	@Test
	public void getPlayers() {
		playerService.players = players;
		assertEquals(players, playerService.getPlayers());
	}

	/*
	 * This test case to get Player Details
	 */
	@Test
	public void getPlayerDetails() {
		assertEquals(new Player("X", "Player 1"), playerService.getPlayer("X"));
	}
	
}
