package com.example.tictactoe.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.tictactoe.pojo.GameResponse;
import com.example.tictactoe.pojo.Player;
import com.example.tictactoe.services.GameService;
import com.example.tictactoe.services.PlayerService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/*
 * This controller manages calls for different scenarios for playing game
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
    public GameResponse play(@RequestParam String position,@RequestParam String playerId)  throws Exception{
    	return gameService.play(position, playerId);
    }
}
