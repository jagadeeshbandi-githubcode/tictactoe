package com.example.tictactoe.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/*
 * This service is to manage games by getting game board 
 * details and playing by turns
 */
@Service
public class GameService {

    public Map<String, String> board;

    public GameService() {
    	newGame();
    }

    public void newGame() {
    	this.board = new HashMap<>();
    	this.board.put("1", null);
    	this.board.put("2", null);
    	this.board.put("3", null);
    	this.board.put("4", null);
    	this.board.put("5", null);
    	this.board.put("6", null);
    	this.board.put("7", null);
    	this.board.put("8", null);
    	this.board.put("9", null);
    }
    
}
