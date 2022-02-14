package game.core.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardEndResultTest {


    //positive tests
    /**
     * p1 wins on first row
     */
    @org.junit.jupiter.api.Test
    void p1wins1Row() {
        char[] positions = {'X', 'X', 'X',
                ' ', ' ', ' ',
                ' ', ' ', ' '};
        Board board = new Board(positions);

        assertEquals(1, board.gameResult());

    }

    /**
     * p1 wins on second row
     */
    @org.junit.jupiter.api.Test
    void p1wins2Row() {
        char[] positions = {' ', ' ', ' ',
                'X', 'X', 'X',
                ' ', ' ', ' '};
        Board board = new Board(positions);

        assertEquals(1, board.gameResult());
    }

    /**
     * p2 wins on 3 row
     */
    @org.junit.jupiter.api.Test
    void p2wins3Row() {
        char[] positions = {' ', ' ', ' ',
                'O', 'O', 'O',
                ' ', ' ', ' '};
        Board board = new Board(positions);

        assertEquals(2, board.gameResult());
    }

    /**
     * p1 wins on colums
     */
    @org.junit.jupiter.api.Test
    void p1wins1Colum(){
        char[] positions =
                {'X', ' ', ' ',
                 'X', ' ', ' ',
                 'X', ' ', ' '};
        Board board = new Board(positions);

        assertEquals(1, board.gameResult());
    }

    /**
     * no one wins
     */
    @org.junit.jupiter.api.Test
    void noOneWins() {
        char[] positions = {' ', ' ', ' ',
                ' ', ' ', 'O',
                ' ', ' ', ' '};
        Board board = new Board(positions);

        assertEquals(0, board.gameResult());
    }

    /**
     * draw
     * */
    @org.junit.jupiter.api.Test
    void draw() {
        char[] positions =
                {'X', 'O', 'X',
                        'X', 'O', 'O',
                        'O', 'X', 'X'};
        Board board = new Board(positions);

        assertEquals(-2, board.gameResult());
    }

    /**
     * last win
     */
    @Test
    void lastWin(){
        char[] positions =
                {'X', 'O', 'X',
                        'O', 'X', 'O',
                        'O', 'X', 'X'};
        Board board = new Board(positions);

        assertEquals(1,board.gameResult());
    }


    /**
     * generic test
     */
    @Test
    void noOneWins2(){
        char[] positions =
                {'X', 'X', ' ',
                        'O', 'O', ' ',
                        ' ', ' ', ' '};
        Board board = new Board(positions);

        assertEquals(0,board.gameResult());


    }


    /**
     * available moves
     */
    @Test
    void availablePostions(){
        char[] positions =
                {'X', 'X', ' ',
                        'O', 'O', ' ',
                        ' ', ' ', ' '};

        Board board = new Board(positions);

        assertEquals(5, board.getAvailablePositions().size());

        assertEquals(2, board.getAvailablePositions().get(0));
        assertEquals(5, board.getAvailablePositions().get(1));
        assertEquals(6, board.getAvailablePositions().get(2));
        assertEquals(7, board.getAvailablePositions().get(3));
        assertEquals(8, board.getAvailablePositions().get(4));



    }


}