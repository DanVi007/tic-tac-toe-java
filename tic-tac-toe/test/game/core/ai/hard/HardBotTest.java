package game.core.ai.hard;

import game.core.board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HardBotTest {

    @Test
    void miniMax() {
        char[] positions =
                {'X', 'X', ' ',
                        'O', 'O', ' ',
                        ' ', ' ', ' '};
        Board board = new Board(positions);

        HardBot bot = new HardBot();
        bot.botMove(board,1);

        System.out.println(board.toString());

        //assertEquals(true,bot.botMove(board,1));

    }


    @Test
    void blockMove(){
        char[] positions =
                       {'O', 'X', 'O',
                        'O', 'X', 'O',
                        'X', ' ', ' '};
        Board board = new Board(positions);
        HardBot bot = new HardBot();
        bot.botMove(board,2);

        System.out.println(board.toString());


    }

}