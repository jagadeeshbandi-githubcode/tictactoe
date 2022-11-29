package com.example.tictactoe.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.tictactoe.pojo.GameResponse;
import com.example.tictactoe.pojo.Player;
import com.example.tictactoe.services.GameService;
import com.example.tictactoe.services.PlayerService;

/*
 * This controller test class has test cases to manages calls for playing game
 */
@WebMvcTest(GameController.class)
public class GameControllerTest {

	@MockBean
	private GameService gameService;
	
	@MockBean
	private PlayerService playerService;

	Map<String,String> board;
	
	@Autowired
	private GameController gameController;
	
	@BeforeEach
	public void setBoard() {
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
	
	/*
	 * This controller test method used to get current board details
	 */
	@Test
	public void getBoard() throws Exception {
		gameService.board = board;
		assertEquals(board , gameController.getState());
	}
	
	/*
	 * This controller test method used to start new Game
	 */
	@Test
	public void startNewGame() throws Exception {
		gameService.board = board;
		assertEquals(board , gameController.newGame());
	}
	
	/*
	 * This controller moves position for a player
	 */
	@Test
	public void playGame() throws Exception {
		
		board.put("1", "X");
		gameService.board = board;
		when(gameService.play("1", "X")).thenReturn(new GameResponse(null, board,null));
		assertEquals(new GameResponse(null, board,null) , gameController.play("1","X"));

	}
	
	/*
	 * This controller moves position for a player and showing player X wins
	 */
	@Test
	public void playGameForXWinnnig() throws Exception {
		
		board.put("1", "X");
		board.put("4", "O");
		board.put("2", "X");
		board.put("5", "O");
		board.put("3", "X");
		gameService.board = board;
		when(gameService.play("3", "X")).thenReturn(new GameResponse(new Player("X", "Player 1"), null ,null) );
		assertEquals(new GameResponse(new Player("X", "Player 1"), null ,null)  , gameController.play("3","X"));

	}
}
