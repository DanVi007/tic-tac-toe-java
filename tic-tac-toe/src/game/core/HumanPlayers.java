package game.core;


import game.core.board.Board;

/**
 * for player vs player
 */
public class HumanPlayers {


    public HumanPlayers(){

    }

    public boolean playerMove(Board board, int position, int playerNumber){
        if(board.positionTaken(position-1)){
            board.setPositions(position-1,playerNumber);
            return true;
        }
        return false;
    }




}
