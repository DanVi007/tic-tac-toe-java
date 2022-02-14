package game.core.ai.hard;

import game.core.board.Board;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * p1 is 1 = -max
 * p2 is -1 = max
 */
public class Node{
    private int positionPlayed;
    private ArrayList<Node> children;
    private int depth;
    private Board gamePosition;
    private int playerNumber;
    private int bestMove;


    public int getPositionPlayed() {
        return positionPlayed;
    }

    public int getBestMove(){
        return bestMove;
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
        this.gamePosition =  new Board(gamePosition);
        this.depth = depth;
        this.playerNumber = playerNumber;
        this.positionPlayed = positionPlayed;
        if(depth >= 0 ){
            createChildren();
        }
    }

    public Node(Board gamePosition, int depth,
                int playerNumber){
        this.gamePosition = new Board(gamePosition);
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

            //int playerNumberTranslation = (int)(1.5 + 0.5*playerNumber);
            // 1 becomes 1 , -1 becomes 2
            int playerNumberTranslation = (int)(1.5 - 0.5*playerNumber);

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
    public int miniMax() {

        if(children.isEmpty() && gameResult() == 0){
            return 0;
        }else if(depth == 0 && gameResult() == 0){
            return 0;
        } else if(gameResult() == Integer.MAX_VALUE){
            return gameResult();
        } else if(gameResult() == -Integer.MAX_VALUE){
            return  gameResult();
        }

        if(playerNumber == 1){
            int maxEval = Integer.MAX_VALUE;
            //int maxEval = 0;
            for(Node child : children){
                int eval = child.miniMax();
                if(eval < maxEval){
                    maxEval = eval;
                    bestMove = child.getPositionPlayed();
                }
            }
            return maxEval;
        } else {
            int minEval = -Integer.MAX_VALUE;
            //int minEval = 0;
            for(Node child : children){
                int eval = child.miniMax();

                if(eval > minEval){
                    minEval = eval;
                    bestMove = child.getPositionPlayed();
                }
            }
            return minEval;
        }
    }



    public int gameResult() {
        int gameResult = gamePosition.gameResult();
        if (gameResult == 1) {
            return -Integer.MAX_VALUE;
        } else if (gameResult == 2) {
            return Integer.MAX_VALUE;
        }
        return 0;
    }














}
