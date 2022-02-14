package game.core.ai.hard;

import game.core.board.Board;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void createChildren(){
        char[] positions =
                {'X', 'X', ' ',
                        'O', 'O', ' ',
                        ' ', ' ', ' '};
        Node node = new Node(new Board(positions),3,-1);

        ArrayList<Node> children = node.getChildren();


        for(Node child : node.getChildren()){
            System.out.println(child.getGamePosition().toString());
        }


        assertEquals(5, children.size());

    }


    @Test
    void checkChildren(){
        char[] positions =
                {'X', 'X', ' ',
                        'O', ' ', ' ',
                        ' ', ' ', ' '};
        Board board = new Board(positions);
        Node node = new Node(board,10,1);
        ArrayList<Node> children = node.getChildren();

        System.out.println(children.get(1).getChildren().get(1).getGamePosition().toString());



    }

    @Test
    void checkChildren2(){
        char[] positions =
                {'X', 'X', ' ',
                        'O', ' ', ' ',
                        ' ', ' ', ' '};
        Board board = new Board(positions);

        Node node = new Node(board,10,1);


    }

    @Test
    void checkChildren3(){
        char[] positions =
                {'O', 'X', 'O',
                        'O', 'X', 'O',
                        'X', ' ', ' '};
        Board board = new Board(positions);
        Node node = new Node(board, 10, -1);

        for(Node child: node.getChildren()){
            System.out.println(child.getGamePosition().toString());
        }


    }


    /**
     * https://www.techiedelight.com/copy-objects-in-java/
     * https://www.baeldung.com/java-deep-copy
     */
    @Test
    void random(){
        char[] positions =
                {'X', 'X', ' ',
                        'O', 'O', ' ',
                        ' ', ' ', ' '};
        Board board = new Board(positions);

        //System.out.println(board.getPositions());

        //Board somethingElse = new Board(board);
        Board somethingElse = board;

        somethingElse.setPositions(5,1);
        System.out.println(board.getPositions());
        System.out.println(somethingElse.getPositions());
       /*
        char[] positions2 =
                {'X', 'X', ' ',
                        'O', 'O', ' ',
                        'Z', ' ', ' '};


        Board evenBetter = new Board(positions2);



        evenBetter.setPositions(8,1);
*/

        somethingElse.setPositions(2,1);

        System.out.println(board.equals(somethingElse));
        System.out.println(board.toString());
        System.out.println(somethingElse.toString());
        //System.out.println(evenBetter.toString());




    }


}