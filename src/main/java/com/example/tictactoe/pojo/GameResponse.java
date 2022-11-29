package com.example.tictactoe.pojo;

import java.util.Map;

/*
 * This Response holds data with 
 * gameOver - boolean value showing if game is completed or not 
 * winner - Player object if game completed otherwise null value
 * board -  Map object of String key and values. key is the position and value is the playerId
 * message - any validation message if exists otherwise null value will be returned
 */
public class GameResponse {
	
    public Boolean gameOver = false;
    public Player winner;
    public Map<String, String> state;
    public String message;

    public GameResponse(Player winner, Map<String, String> state,String message) {
        if(winner != null) {
            this.winner = winner;
            this.gameOver = true;
            this.state = null;
        }else {
        	this.state = state;
        }
        
        this.message = message;
    }

    public void setGameOver(Boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void setState(Map<String, String> state) {
        this.state = state;
    }

    public Boolean getGameOver() {
        return gameOver;
    }

    public Map<String, String> getState() {
        return state;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "GameResponse [gameOver=" + gameOver + ", winner=" + winner + ", state=" + state + ", message=" + message
				+ "]";
	}

	
	@Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        GameResponse guest = (GameResponse) obj;
        return gameOver == guest.gameOver
                && (message == guest.message || (message!=null && message.equals(guest.message)))
                && ((winner == guest.winner) || (winner!=null && winner.getId() == guest.winner.getId() && winner.getDescription() == guest.winner.getDescription()))
                && state == guest.state;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gameOver == null) ? 0 : gameOver.hashCode());
        result = prime * result + ((message == null) ? 0 : message.hashCode());
        result = prime * result + ((winner.getId() == null) ? 0 : winner.getId().hashCode());
        result = prime * result + ((winner.getDescription() == null) ? 0 : winner.getDescription().hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        return result;
    }

}
