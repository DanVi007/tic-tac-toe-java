package game.core;

public class PvPSystem {
    private Board board;

    public PvPSystem(Board board){
        this.board = board;
    }

    public boolean playerMove(int position, int playerNumber){
        if(board.positionTaken(position)){
            board.setPositions(position,playerNumber);
            return true;
        }
        return false;
    }



}
