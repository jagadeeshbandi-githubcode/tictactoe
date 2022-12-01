package com.example.tictactoe.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.tictactoe.pojo.GameResponse;
import com.example.tictactoe.pojo.Player;

/*
 * This service test class contains test cases for different scenarios of playing game
 */
@SpringBootTest
class GameServiceTest {
  
	@Autowired
	private GameService gameService;

	@Autowired
    private PlayerService playerService;
	
	Map<String,String> board;
  
	@BeforeEach
	void setup() {
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
		gameService.gameOver = false;
	}

	/*
	 * This test case to return current board
	 */
	@Test
	void getBoard() {
		gameService.board = board;
		assertEquals(board, gameService.board);
	}

	
	/*
	 * This test case to show player X wins
	 */
	@Test
	void testCheckWinner() {
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
	void testCheckWinnerForO() {
		
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
	
	
	/*
	 * This test case to draw the match
	 */
	@Test
	void testCheckWinnerToDraw() {
		
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
		
		board.put("8", "O");
		gameService.board = board;
		assertEquals(null, gameService.checkWinner());
		
		board.put("7", "X");
		gameService.board = board;
		assertEquals(null, gameService.checkWinner());
		
		board.put("4", "O");
		gameService.board = board;
		assertEquals("draw", gameService.checkWinner());
		
	}
	
	/*
	 * This test case to check if the first move is done by Player O
	 */
	@Test
	void testCheckIfFirstMoveIsByO() {
		
		gameService.board = board;
		assertEquals(true, gameService.checkIfFirstMoveIsByO("O"));
	}
	
	/*
	 * This test case to check if the first move is done by Player O but board filled with move
	 */
	@Test
	void testCheckIfFirstMoveIsByO_Negative() {
		board.put("8", "O");
		gameService.board = board;
		assertEquals(false	, gameService.checkIfFirstMoveIsByO("O"));
	}
	
	/*
	 * This test case to check if the first move is done by Player O
	 */
	@Test
	void testCheckIfFirstMoveIsByX() {
		gameService.board = board;
		assertEquals(false, gameService.checkIfFirstMoveIsByO("X"));
	}
	
	/*
	 * This test case updates board with the position which player moved
	 */
	@Test
	void testPlay() {
		gameService.board = board;
		assertEquals(new GameResponse(null, board,null) , gameService.play("1","X"));
	}
	
	/*
	 * This test case to validate if first move should be from Player X
	 */
	@Test
	void testIfFirstMoveIsByOPlayMethod() {
		gameService.board = board;
		assertEquals(new GameResponse(null, null ,"Only Player X can make first move!") , gameService.play("1","O"));
	}
	
	/*
	 * This test case to validate position is already taken in previous moves
	 */
	@Test
	void testPlayForSamePosition() {
		board.put("1", "X");
		gameService.board = board;
		assertEquals(new GameResponse(null, null ,"The position 1 is already taken!") , gameService.play("1","O"));
	}
	
	/*
	 * This test case to validate if same player moves multiple times
	 */
	@Test
	void testPlayIfSamePlayerMoves() {
		playerService.played = "X";
		board.put("1", "X");
		gameService.board = board;
		assertEquals(new GameResponse(null, null ,"Player X already played!") , gameService.play("2","X"));
	}
	
	/*
	 * This test case for already completed game
	 */
	@Test
	void testIfGameOver() {
		gameService.gameOver = true;
		board.put("1", "X");
		board.put("4", "O");
		board.put("2", "X");
		board.put("5", "O");
		board.put("3", "X");
		gameService.board = board;
		assertEquals(new GameResponse(new Player("X", "Player 1"), null ,null) , gameService.play("6","O"));
	}
	
	
	/*
	 * This test case for finding Winner when match is draw
	 */
	@Test
	void testFindWinnerforDraw() {
		board.put("1", "X");
		board.put("3", "O");
		board.put("2", "X");
		board.put("5", "O");
		board.put("6", "X");
		board.put("8", "O");
		board.put("7", "X");
		board.put("4", "O");
		gameService.board = board;
		assertEquals(new Player("draw", "No one wins") , gameService.findWinner());
	}
	
	
	/*
	 * This test case for finding Winner when player X wins
	 */
	@Test
	void testFindWinner_PlayerXWin() {
		board.put("1", "X");
		board.put("4", "O");
		board.put("2", "X");
		board.put("5", "O");
		board.put("3", "X");
		gameService.board = board;
		assertEquals(new Player("X", "Player 1") , gameService.findWinner());
	}
	
	/*
	 * This test case for finding Winner when player O wins
	 */
	@Test
	void testFindWinner_PlayerOWin() {
		board.put("1", "X");
		board.put("4", "O");
		board.put("2", "X");
		board.put("5", "O");
		board.put("8", "X");
		board.put("6", "O");
		gameService.board = board;
		assertEquals(new Player("O", "Player 2") , gameService.findWinner());
	}
}
