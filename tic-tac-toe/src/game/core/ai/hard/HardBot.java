package game.core.ai.hard;

import game.core.board.Board;

public class HardBot {
    private int depth;
    private Board board;
    private int playerNumber;

    public HardBot(){
        this.depth = 9;

    }

    private int getBestMove(){
        Node node = new Node(this.board,depth, this.playerNumber);
        node.miniMax();
        int bestMove = node.getBestMove();

        return bestMove;
    }


    public void botMove(Board board, int playerNumber){
        this.board = board;
        //this.playerNumber = 3-2*playerNumber;
        this.playerNumber = 2*playerNumber -3;
        int moveToPlay = getBestMove();
        board.setPositions(moveToPlay,playerNumber);


    }







}
