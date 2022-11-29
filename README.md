# Getting Started

Tic Tac Toe game has a grid of 3x3, the playerIds are "X" and "O". Player X should have first move always.

When any player moves with a position then that respective position will be filled in the grid.

Always play should happen on turns i.e., First Player X then Player O and then Player X.

If any player moves with some position and if any of the complete line is filled with same player then that player is declared as winner. It can be horizontal/Vertical/Diaganol line.

Three API endpoints are provided

1.	GET /board
2.	GET /players
3.  GET /newGame
4.	GET /play

# How to run

Download zip file from https://github.com/jagadeeshbandi-githubcode/tictactoe from Code option

Unzip the downloaded file. Go to project folder and run below command from command prompt(Make sure maven is installed)

	mvn spring-boot:run

Open browser and access endpoints as below samples

http://localhost:8080/play?position=1&playerId=X

http://localhost:8080/players

http://localhost:8080/board

http://localhost:8080/newGame


# Assumptions

Only one game can be played at a time. 

/newGame endpoint is used to restart game if required.

# Technical Specifications

Java 8, Spring Boot ( REST, WEB, Test) , Maven , GIT

# Endpoints

## 1. GET /board

Returns the current state of the board as a Map of String key and values. key is the position and value is the playerId.
URL: http://localhost:8080/board

Sample response

{
    "1": null,
    "2": null,
    "3": null,
    "4": null,
    "5": null,
    "6": null,
    "7": null,
    "8": null,
    "9": null
}

## 2. GET /players

Returns a list of the available players.
URL: http://localhost:8080/players

Sample response

[
    {
        "id": "X",
        "description": "Player 1"
    },
    {
        "id": "O",
        "description": "Player 2"
    }
]


## 3. GET /newGame

It will reset the board and returns board as a Map of String key and values. key is the position and value is the playerId.
URL: http://localhost:8080/newGame

Sample response

{
    "1": null,
    "2": null,
    "3": null,
    "4": null,
    "5": null,
    "6": null,
    "7": null,
    "8": null,
    "9": null
}


## 4. GET /play

Called every time a player takes a turn on the board. Position and PlayerId are request params we can send in URL.

URL: http://localhost:8080/play?position=1&playerId=X

Sample response - Ongoing game gameOver field will be false as long as the game is ongoing.

{
    "gameOver": false,
    "winner": null,
    "state": {
		"1": null,
		"2": null,
		"3": null,
		"4": null,
		"5": null,
		"6": null,
		"7": null,
		"8": null,
		"9": null
    }
	"message": null,
}


### Sample response when Game finished

When there is a winner GET request will return with 200 and return the winner.


•	gameOver - true once there is a winner in the game.

•	winner - contains the winner.

{
    "gameOver": true,
    "winner": {
        "id": "X",
        "description": "Player 1"
    },
    "state": null,
	"message": null
}


### Sample response - Player X already played

URL: http://localhost:8080/play?position=2&playerId=X

Sample response - Ongoing game with same player X played without player O turn

{
	"gameOver": false,
    "winner": null,
    "state": null,
	"message": "Player X already played!"
}



### Sample response - The position is already taken!

URL: http://localhost:8080/play?position=1&playerId=O

Sample response - Ongoing game with position 1 is again moved by player O

{
	"gameOver": false,
    "winner": null,
    "state": null,
	"message": "The position 1 is already taken!"
}


### Sample response - Player X should make first move

http://localhost:8080/newGame <br/>
http://localhost:8080/play?position=1&playerId=O

Sample response - New Game and when player O playes first. Show message as below

{
	"gameOver": false,
    "winner": null,
    "state": null,
	"message": "The position 1 is already taken!"
}




