package com.example.tictactoe.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private final PlayerService playersService;

    @Autowired
    public GameController(GameService gameStateService, PlayerService playersService) {
        this.gameStateService = gameStateService;
        this.playersService = playersService;
    }


    /** 
     * This is the method gives current board status. 
     * @return Map<String,String> . 
     */
    @GetMapping("/board")
    public Map<String, String> getState() {
        return gameStateService.board;
    }

}
