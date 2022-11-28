package com.example.tictactoe.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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
    
    /*
     * This method checks if players wins or not
     * Will check if same player occupies box continuously in single line or in diagonal line
     * if all boxes are filled and no one wins , it is declared draw
     */
    public String checkWinner() {
        for (int x = 1; x < 9; x++) {
            String line = null;
            switch (x) {
                case 1:
                    line = board.get("1") + board.get("2") + board.get("3");
                    break;
                case 2:
                    line = board.get("4") + board.get("5") + board.get("6");
                    break;
                case 3:
                    line = board.get("7") + board.get("8") + board.get("9");
                    break;
                case 4:
                    line = board.get("1") + board.get("4") + board.get("7");
                    break;
                case 5:
                    line = board.get("2") + board.get("5") + board.get("8");
                    break;
                case 6:
                    line = board.get("3") + board.get("6") + board.get("9");
                    break;
                case 7:
                    line = board.get("1") + board.get("5") + board.get("9");
                    break;
                case 8:
                    line = board.get("3") + board.get("5") + board.get("7");
                    break;
            }
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }

        if(board.values().stream().filter(Objects::nonNull).collect(Collectors.toList()).size() == 8) {
            return "draw";
        }

        return null;
    }
}
