package game.ui;

import game.core.board.Board;
import game.core.PvPSystem;
import game.ui.utilities.Input;
import game.ui.utilities.output.Output;


public class Application {
    private Board board;
    private PvPSystem pvpSystem;
    private Output output;
    private Input input;

    public Application(){
        input = new Input();
        output = new Output();
        pvpSystem = new PvPSystem();
    }

    public void menu(){

    }

    /**
     * optimise
     */
    private void pvpGame(){
        board = new Board();
        boolean gameEnd = false;

        do {
           output.printInfo(board.toString());
           output.askForMove();
           int move = input.getNumber(1,9);
           pvpSystem.playerMove(board,move,1);
           output.printInfo(board.toString());

           int result = board.gameResult();

           if(result == -2){
               output.drawMessage();
               gameEnd = true;
           }else if(result == 1 || result== 2){
               output.winnerMessage(result);
               gameEnd = true;
            } else if(result == 0){
               output.askForMove();
               move = input.getNumber(1,9);
               pvpSystem.playerMove(board,move,2);
           }

        } while(!gameEnd);


    }


    public static void main(String[] args) {
        Application application = new Application();
        application.pvpGame();
    }


}
