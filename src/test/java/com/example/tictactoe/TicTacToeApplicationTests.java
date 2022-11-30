package com.example.tictactoe;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
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
