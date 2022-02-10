package game.core.ai.hard;

import game.core.board.Board;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * p1 is 1 = max
 * p2 is -1 = - max
 */
public class Node extends Board{
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

    private void createChildren(){
        children = new ArrayList<>();
        for(int position : Board.ALL_POSITIONS){
            Board newGamePosition = this.gamePosition;
            if(newGamePosition.setPositions(position, playerNumber)){
                children.add(
                        new Node(newGamePosition,depth-1,
                                -playerNumber,position));
            }
        }
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
