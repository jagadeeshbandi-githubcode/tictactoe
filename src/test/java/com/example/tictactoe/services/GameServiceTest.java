package com.example.tictactoe.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GameServiceTest {
  
	private GameService state;

	Map<String,String> board;
  
	@BeforeEach
	public void setup() {
		state = new GameService();
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
		assertEquals(board, state.board);
	}

}
