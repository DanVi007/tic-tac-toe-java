package game.core.ai.hard;

import game.core.board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HardBotTest {

    @Test
    void winGame() {
        char[] positions =
                {'X', 'X', ' ',
                        'O', 'O', ' ',
                        ' ', ' ', ' '};
        Board board = new Board(positions);

        HardBot bot = new HardBot();
        bot.botMove(board,1);

        char[] expectedPositions =
                {'X', 'X', 'X',
                        'O', 'O', ' ',
                        ' ', ' ', ' '};


        assertArrayEquals(expectedPositions, board.getPositions());
    }


    @Test
    void trickyWin(){
        char[] positions =
                       {'O', 'X', 'O',
                        'O', 'X', 'O',
                        'X', ' ', ' '};
        Board board = new Board(positions);
        HardBot bot = new HardBot();
        bot.botMove(board,2);
        char[] expectedPositions =
                {'O', 'X', 'O',
                        'O', 'X', 'O',
                        'X', ' ', 'O'};

        assertArrayEquals(expectedPositions, board.getPositions());


    }

    @Test
    void blockWin(){
        char[] positions =
                        {'X', 'O', 'X',
                        ' ', 'O', ' ',
                        'O', 'X', 'X'};
        Board board = new Board(positions);
        HardBot bot = new HardBot();
        bot.botMove(board,2);
        char[] expectedPositions =
                {'X', 'O', 'X',
                        ' ', 'O', 'O',
                        'O', 'X', 'X'};


        assertArrayEquals(expectedPositions, board.getPositions());




    }

}