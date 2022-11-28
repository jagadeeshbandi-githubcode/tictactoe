package com.example.tictactoe.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tictactoe.pojo.Player;

/*
 * This service is to manage players and to get Player Details
 */
@Service
public class PlayerService {
    
	List<Player> players;
	
    public PlayerService() {
        players = new ArrayList<>(2);
        players.add(new Player("X", "Player 1"));
        players.add(new Player("O", "Player 2"));
    }

    public List<Player> getPlayers() {
        return players;
    }

}
