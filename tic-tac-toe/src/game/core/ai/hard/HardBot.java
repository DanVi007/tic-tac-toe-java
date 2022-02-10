package game.core.ai.hard;

import game.core.board.Board;

public class HardBot {
    private int bestMove;








    /**
     * p1 is 1 = max
     * p2 is -1 = - max
     */
    public int miniMax(Node node){
            if(node.getDepth() == 0 && node.gameResult() == 0){
                return 0;
            }else if(node.getDepth() == 0 || Math.abs(node.gameResult()) == Integer.MAX_VALUE){
                return node.getPlayerNumber() == 1 ? Integer.MAX_VALUE : -Integer.MAX_VALUE;
            }


            if(node.getPlayerNumber() == 1){
                int maxEval = Integer.MAX_VALUE;

                for(Node child : node.getChildren()){
                    int eval = miniMax(child);
                    if(eval < maxEval){
                        maxEval = eval;
                        bestMove = child.getPositionPlayed();
                    }
                }
                return maxEval;
            } else {
                int minEval = - Integer.MAX_VALUE;

                for(Node child : node.getChildren()){
                    int eval = miniMax(child);

                    if(eval < minEval){
                        minEval = eval;
                        bestMove = child.getPositionPlayed();
                    }
                }
                return minEval;
            }
    }




}
