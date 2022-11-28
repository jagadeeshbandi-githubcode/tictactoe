package com.example.tictactoe.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GameServiceTest {
  
	private GameService gameService;

	Map<String,String> board;
  
	@BeforeEach
	public void setup() {
		gameService = new GameService();
		board = new HashMap<>();
		board.put("1", null);
		board.put("2", null);
		board.put("3", null);
		board.put("4", null);
		board.put("5", null);
		board.put("6", null);
		board.put("7", null);
		board.put("8", null);
		board.put("9", null);
	}

	@Test
	public void getBoard() {
		assertEquals(board, gameService.board);
	}

	
	/*
	 * This test case to show player X wins
	 */
	@Test
	public void checkWinner() {
		board.put("1", "X");
		gameService.board = board;
		assertEquals(null, gameService.checkWinner());
		
		board.put("4", "O");
		gameService.board = board;
		assertEquals(null, gameService.checkWinner());
		
		board.put("2", "X");
		gameService.board = board;
		assertEquals(null, gameService.checkWinner());
		
		board.put("5", "O");
		gameService.board = board;
		assertEquals(null, gameService.checkWinner());
		
		board.put("3", "X");
		gameService.board = board;
		assertEquals("X", gameService.checkWinner());
	}
	
	
	/*
	 * This test case to show player O winning in diagonal line
	 */
	@Test
	public void checkWinnerForO() {
		
		board.put("1", "X");
		gameService.board = board;
		assertEquals(null, gameService.checkWinner());
		
		board.put("3", "O");
		gameService.board = board;
		assertEquals(null, gameService.checkWinner());
		
		board.put("2", "X");
		gameService.board = board;
		assertEquals(null, gameService.checkWinner());
		
		board.put("5", "O");
		gameService.board = board;
		assertEquals(null, gameService.checkWinner());
		
		board.put("6", "X");
		gameService.board = board;
		assertEquals(null, gameService.checkWinner());
		
		board.put("7", "O");
		gameService.board = board;
		assertEquals("O", gameService.checkWinner());
	}
	
}
