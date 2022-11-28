package com.example.tictactoe.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.tictactoe.controller.GameController;
import com.example.tictactoe.services.GameService;
import com.example.tictactoe.services.PlayerService;

@WebMvcTest(GameController.class)
public class GameControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GameService gameStateService;
	
	@MockBean
	private PlayerService playersService;

	Map<String,String> board;
	
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
		String response = "{\"1\":null,\"2\":null,\"3\":null,\"4\":null,\"5\":null,\"6\":null,\"7\":null,\"8\":null,\"9\":null}";
		gameStateService.board = board;
		this.mockMvc.perform(get("/board")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString(response)));
	}
	
	/*
	 * This controller test method used to start new Game
	 */
	@Test
	public void startNewGame() throws Exception {
		String response = "{\"1\":null,\"2\":null,\"3\":null,\"4\":null,\"5\":null,\"6\":null,\"7\":null,\"8\":null,\"9\":null}";
		gameStateService.board = board;
		this.mockMvc.perform(get("/newGame")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString(response)));
	}
}
