package com.example.tictactoe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tictactoe.pojo.GameResponse;
import com.example.tictactoe.pojo.Player;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/*
 * This service is to manage games by getting game board details and playing by turns
 * checkWinner - to check if any player wins
 * checkIfFirstMoveIsByO - validation method to check if first move is made by player O
 * play - method to play game on turns and respond with GameResponse object
 * findWinner - To get winner details if completed otherwise null value
 */
@Service
public class GameService {

    public Map<String, String> board;

    public Boolean gameOver;
    
    @Autowired
    private PlayerService playerService;
    
    /*
     * Constructor Method to start new Game
     */
    public GameService() {
    	newGame();
    }

    /*
     * Method to start new Game
     */
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
    	this.gameOver = false;
    }
    
    /*
     * This method checks if players wins or not
     * Will check if same player occupies box continuously in single line or in diagonal line
     * if all boxes are filled and no one wins , it is declared draw
     */
    public String checkWinner() {
        for (int x = 1; x <= 9; x++) {
            String line = "";
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
            } 
            if (line.equals("OOO")) {
                return "O";
            }
        }

        if(board.values().stream().filter(Objects::nonNull).collect(Collectors.toList()).size() == 8) {
            return "draw";
        }

        return null;
    }
    
    /*
     * This method checks if the first move is made my Player O
     */
    public boolean checkIfFirstMoveIsByO(String player) {
    	return this.board.values().stream().filter(Objects::isNull).count() == this.board.size() && player.equals("O") ? true : false;
    }
    
    public Boolean isGameOver() {
        return gameOver;
    }

    public void endGame(Boolean gameOver) {
        this.gameOver = gameOver;
    }
    
    /*
     * This method has different checks if move is proper, if correct it willl update board
     * 1st Check - if game is already completed
     * 2nd check - if same player moves multiple times
     * 3rd check - if same position is already moved
     * 4th check - always player X should make first move
     * if none of the above conditions satisfies it will update board
     */
    public GameResponse play(String position,String playerId) {
    	if (isGameOver()) {
            return new GameResponse(findWinner(), board,null);
        } else if(playerService.played!=null && playerService.played.equalsIgnoreCase(playerId)) {
            return new GameResponse(findWinner(), null ,"Player "+playerId+" already played!");
        } else if (board.get(position) != null) {
        	return new GameResponse(findWinner(), null ,"The position "+position+" is already taken!");
        } else if(checkIfFirstMoveIsByO(playerId)) {
            return new GameResponse(findWinner(), null ,"Only Player X can make first move!");
        } else {
	    	playerService.played = playerId;
	    	board.put(position, playerId);
	        return new GameResponse(findWinner(), board,null);
        }
    }
    
    /*
     * This method gives player details if won otherwise null
     */
    public Player findWinner() {
        String winner = checkWinner();
        Player playerWinner=null;

        if(winner!=null) {
        	if(winner.equals("X") || winner.equals("O")) {
	        	playerWinner = playerService.getPlayer(winner);
	            endGame(true);
	            playerService.played = null;
        	}
        	else {
	        	 playerWinner = new Player("draw", "No one wins");
	             endGame(true);
	             playerService.played = null;
	        }
        	return playerWinner;
        }
        return null;
    }
}
