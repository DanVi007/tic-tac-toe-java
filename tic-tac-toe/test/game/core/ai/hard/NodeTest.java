package game.core.ai.hard;

import game.core.board.Board;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void createChildren(){
        char[] position =
                {'X', 'X', ' ',
                        'O', 'O', ' ',
                        ' ', ' ', ' '};
        Node node = new Node(new Board(position),3,-1);
        int[] availablePositions = {2,5,6,7,8};
        int i = 0;
        ArrayList<Node> children = node.getChildren();
        assertEquals(5, children.size());
        for(Node child : children){
            assertEquals(availablePositions[i],child.getPositionPlayed());
            assertEquals('O', child.getGamePosition().getPositions()[availablePositions[i]]);
            i++;
        }
    }


    @Test
    void checkChildren(){
        char[] position =
                {' ', ' ', ' ',
                        ' ', ' ', ' ',
                        ' ', ' ', ' '};
        Board board = new Board(position);
        Node node = new Node(board,9,1);
        ArrayList<Node> children = node.getChildren();

        char[] expectedLastPosition =
                {'X', 'O', 'X',
                        'O', 'X', 'O',
                        'X', 'O', 'X'};

        Node lastPosition = children.get(0);
        for(int i =0 ; i < 8; i++){
            lastPosition = lastPosition.getChildren().get(0);
        }
        assertArrayEquals(expectedLastPosition, lastPosition.getGamePosition().getPositions());

    }


    @Test
    void checkChildren2(){
        char[] positions =
                {'O', 'X', 'O',
                        'O', 'X', 'O',
                        'X', ' ', ' '};
        Board board = new Board(positions);
        Node node = new Node(board, 9, -1);

        ArrayList<Node> children = node.getChildren();

        char[] expectedPosition1 =
                {'O', 'X', 'O',
                        'O', 'X', 'O',
                        'X', 'O', ' '};
        char[] expectedPosition2 =
                {'O', 'X', 'O',
                        'O', 'X', 'O',
                        'X', ' ', 'O'};

        assertEquals(2,children.size());

        assertArrayEquals(expectedPosition1, children.get(0).getGamePosition().getPositions());

        assertArrayEquals(expectedPosition2,children.get(1).getGamePosition().getPositions());


    }




}