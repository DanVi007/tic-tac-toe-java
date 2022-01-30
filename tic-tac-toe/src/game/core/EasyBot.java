package game.core;

import game.core.board.Board;

import java.util.Random;

public class EasyBot {
    private Random position;

    public EasyBot(){
        position = new Random();
    }

    public boolean botMove(Board board, int playerNumber){
        boolean moveDone = false;
        int position;
        while(!moveDone){
            position = this.position.nextInt(9);
            if(board.positionTaken(position)){
                board.setPositions(position, playerNumber);
                moveDone = true;
            }
        }
       return moveDone;
    }



}
