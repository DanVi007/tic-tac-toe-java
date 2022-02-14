package game.core.board;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    /**
     * https://www.techiedelight.com/copy-objects-in-java/
     * https://www.baeldung.com/java-deep-copy
     */
    @Test
    void copyConstructor(){
        char[] positions =
                {'X', 'X', ' ',
                        'O', 'O', ' ',
                        ' ', ' ', ' '};
        Board board = new Board(positions);
        Board somethingElse = new Board(board);
        assertNotSame(board,somethingElse);

        Board same = board;
        //negative test
        assertEquals(board, same);

    }

    @Test
    void unchangedMutatorInCopy(){
        char[] positions =
                {'X', 'X', ' ',
                        'O', 'O', ' ',
                        ' ', ' ', ' '};
        Board board = new Board(positions);
        Board somethingElse = new Board(board);

        somethingElse.setPositions(2,1);

        char[] changedPositions =
                {'X', 'X', 'X',
                        'O', 'O', ' ',
                        ' ', ' ', ' '};

        assertArrayEquals(changedPositions,somethingElse.getPositions());
        assertArrayEquals(positions, board.getPositions());

    }


}