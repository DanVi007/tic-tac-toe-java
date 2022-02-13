package game.core.ai.hard;

import game.core.board.Board;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * p1 is 1 = max
 * p2 is -1 = - max
 */
public class Node{
    private int positionPlayed;
    private ArrayList<Node> children;
    private int depth;
    private Board gamePosition;
    private int playerNumber;

    public int getPositionPlayed() {
        return positionPlayed;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public int getDepth() {
        return depth;
    }

    public Board getGamePosition() {
        return gamePosition;
    }

    public int getPlayerNumber(){
        return playerNumber;
    }

    public Node(Board gamePosition, int depth,
                int playerNumber, int positionPlayed){
        this.gamePosition = gamePosition;
        this.depth = depth;
        this.playerNumber = playerNumber;
        this.positionPlayed = positionPlayed;
        if(depth > 0 ){
            createChildren();
        }
    }

    public Node(Board gamePosition, int depth,
                int playerNumber){
        this.gamePosition = gamePosition;
        this.depth = depth;
        this.playerNumber = playerNumber;

        if(depth > 0){
            createChildren();
        }
    }

    /**
     * debug
     */
    private void createChildren(){
        children = new ArrayList<>();

        for(int position : this.gamePosition.getAvailablePositions()){
            Board newGamePosition = new Board(gamePosition);

            int playerNumberTranslation = (int)(1.5 + 0.5*playerNumber);


            if(newGamePosition.setPositions(position, playerNumberTranslation)){
            //if(newGamePosition.positionTaken(position)){
                //debug

                newGamePosition.setPositions(position,playerNumberTranslation);
                children.add(
                        new Node(newGamePosition,depth-1,
                                -playerNumber,position));
            }

        }
    }

    /**
     * p1 is 1 = max
     * p2 is -1 = - max
     */
    public int miniMax(){
        if(depth == 0 && gameResult() == 0){
            return 0;
        }else if(depth == 0 || Math.abs(gameResult()) == Integer.MAX_VALUE){
            return playerNumber == 1 ? Integer.MAX_VALUE : -Integer.MAX_VALUE;
        }


        if(playerNumber == 1){
            int maxEval = Integer.MAX_VALUE;

            for(Node child : children){
                int eval = child.miniMax();
                if(eval < maxEval){
                    maxEval = eval;
                    positionPlayed = child.getPositionPlayed();
                }
            }
            return maxEval;
        } else {
            int minEval = - Integer.MAX_VALUE;

            for(Node child : children){
                int eval = child.miniMax();

                if(eval > minEval){
                    minEval = eval;
                    positionPlayed = child.getPositionPlayed();
                }
            }
            return minEval;
        }
    }



    public static void main(String[] args) {
        Node node = new Node(new Board(),5,1);

        node.createChildren();
    }


    public int gameResult() {
        int gameResult = gamePosition.gameResult();
        if (gameResult == 1) {
            return Integer.MAX_VALUE;
        } else if (gameResult == 2) {
            return -Integer.MAX_VALUE;
        }
        return 0;
    }














}
