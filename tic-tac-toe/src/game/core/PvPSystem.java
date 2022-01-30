package game.core;


import game.core.board.Board;

/**
 * for player vs player
 */
public class PvPSystem {


    public PvPSystem(){

    }

    public boolean playerMove(Board board, int position, int playerNumber){
        if(board.positionTaken(position-1)){
            board.setPositions(position-1,playerNumber);
            return true;
        }
        return false;
    }




}
