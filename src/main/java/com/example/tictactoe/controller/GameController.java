package com.example.tictactoe.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.tictactoe.pojo.GameResponse;
import com.example.tictactoe.pojo.Player;
import com.example.tictactoe.services.GameService;
import com.example.tictactoe.services.PlayerService;
import java.util.List;
import java.util.Map;

/*
 * This controller manages calls for playing game
 * Three API end points are provided
 * /board - To return current state of the board
 * /players - To return list of the available players
 * /newGame - To reset the board and returns fresh board
 * /play - To be called every time a player takes a turn on the board
 */
@RestController
public class GameController {

	@Autowired
    private GameService gameService;
	
	@Autowired
    private PlayerService playerService;

    /** 
     * This method gives current board status. 
     * @return Map<String,String> . 
     */
    @GetMapping("/board")
    public Map<String, String> getState() {
        return gameService.board;
    }

    /** 
     * This method returns list of players
     * @return List<Player> . 
     */
    @GetMapping("/players")
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }
   
    /** 
     * This method starts new Game and returns board details
     * @return Map<String,String> 
     */
    @GetMapping("/newGame")
    public Map<String, String> newGame() {
    	gameService.newGame();
        return gameService.board;
    }
    
    /*
     * This method moves position for a player
     * @Input  - position, playerId
     * @return GameReponse
     */
    @GetMapping("/play")
    public GameResponse play(@RequestParam String position,@RequestParam String playerId) {
    	return gameService.play(position, playerId);
    }
}
