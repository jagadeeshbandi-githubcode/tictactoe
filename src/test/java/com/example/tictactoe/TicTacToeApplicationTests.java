package com.example.tictactoe;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TicTacToeApplicationTests {

	@Test
    void test()
    {
		TicTacToeApplication.main(new String[]{
                "--spring.main.web-environment=false",
                "--spring.autoconfigure.exclude=test",
        });
    }

}
