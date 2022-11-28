package com.example.tictactoe.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.tictactoe.pojo.Player;

/*
 * This service is to manage players and to get Player Details
 */
@Service
public class PlayerService {
    
	List<Player> players;
	
	public String played;
	
    public PlayerService() {
        players = new ArrayList<>(2);
        players.add(new Player("X", "Player 1"));
        players.add(new Player("O", "Player 2"));
    }

    public List<Player> getPlayers() {
        return players;
    }

    /*
     * This method returns player details by Id
     * @Input - playerId
     * return - Player details with id and description
     */
    public Player getPlayer(String player) {
        List<Player> collect = players.stream()
                .filter(e -> e.getId().equals(player))
                .collect(Collectors.toList());
        if (collect.size() > 0) {
            return collect.get(0);
        }
        return null;
    }
}
