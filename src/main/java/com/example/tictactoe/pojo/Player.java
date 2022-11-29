package com.example.tictactoe.pojo;

/*
 * Pojo to hold player details
 * id - X or O values
 * description - Player name
 */
public class Player {
	
    private final String id;
    private final String description;

    public Player(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Player guest = (Player) obj;
        return id == guest.id
                && description == guest.description;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
       
        return result;
    }
}
