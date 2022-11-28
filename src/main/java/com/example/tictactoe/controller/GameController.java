package com.example.tictactoe.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    private final GameService gameStateService;
    private final PlayerService playerService;

    @Autowired
    public GameController(GameService gameStateService, PlayerService playersService) {
        this.gameStateService = gameStateService;
        this.playerService = playersService;
    }


    /** 
     * This is the method gives current board status. 
     * @return Map<String,String> . 
     */
    @GetMapping("/board")
    public Map<String, String> getState() {
        return gameStateService.board;
    }

    /** 
     * This is the method returns list of players
     * @return List<Player> . 
     */
    @GetMapping("/players")
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }
}
