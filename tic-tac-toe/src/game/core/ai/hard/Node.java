package game.core.ai.hard;

import game.core.board.Board;

import java.util.ArrayList;

public class Node {
    private int CorrectMoveForBot;
    private ArrayList<Node> children;
    private int depth;
    private Board gamePosition;
    private boolean playerNumber;


    public Node(Board gamePosition, int depth, boolean playerNumber){
        this.gamePosition = gamePosition;
        this.depth = depth;
        this.playerNumber = playerNumber;
    }

    private void CreateChildren(){
        ArrayList<Integer> availablePositions = this.gamePosition.getAvailablePositions();

        for(int position : availablePositions){
            Board newGamePosition = this.gamePosition;
            newGamePosition.setPositions(position, )

            Node child = new Node();
        }




    }





    public int minMax(Board gamePosition, int depth, boolean humanPlayer){

    }

    private int gameEvaluation(Board gamePosition, int depth, boolean humanPlayer){
        if(depth )

    }







}
