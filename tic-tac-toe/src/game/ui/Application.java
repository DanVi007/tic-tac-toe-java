package game.ui;

import game.core.EasyBot;
import game.core.board.Board;
import game.core.HumanPlayers;
import game.ui.utilities.Input;
import game.ui.utilities.output.ErrorMessage;
import game.ui.utilities.output.Output;


public class Application {
    private Board board;
    private HumanPlayers humanPlayers;
    private Output output;
    private Input input;
    private ErrorMessage errorMessage;
    private EasyBot easyBot;


    public Application(){
        input = new Input();
        output = new Output();
        humanPlayers = new HumanPlayers();
        errorMessage = new ErrorMessage();
    }

    public void menu(){

    }

    /**
     *
     */
    private void pvpGame(){
        board = new Board();
        boolean gameEnd = false;

        do {
            //p1 move
           output.printInfo(board.toString());
           playerMove(1);
           output.printInfo(board.toString());

           int result = board.gameResult();

           if(result == -2){
               output.drawMessage();
               gameEnd = true;
           }else if(result == 1 || result== 2){
               output.winnerMessage(result);
               gameEnd = true;
            } else if(result == 0){
               //p2 move
                playerMove(2);
           }
        } while(!gameEnd);
    }

    private void playerMove(int playerNumber){
        output.askForMove();
        int move = input.getNumber(1,9);
        if(!humanPlayers.playerMove(board,move,playerNumber)){
            errorMessage.genericErrorMessage();
        }
    }

    /**
     * fix 
     */
    private void easyBot(){
        easyBot = new EasyBot();
        board = new Board();
        int playerNumber = choosePlayer();
        // to get the reverse playernumber
        int botNumber = 3 - playerNumber;
        boolean humanStart = playerNumber < botNumber;

        boolean gameEnd = false;
        do {
            //p1 move

            output.printInfo(board.toString());
            if(humanStart) {
                playerMove(playerNumber);
            }
            int result = board.gameResult();

            if(result == -2){
                output.drawMessage();
                gameEnd = true;
            }else if(result == 1 || result== 2){
                output.winnerMessage(result);
                gameEnd = true;
            } else if(result == 0){
                //p2 move
                easyBot.botMove(board,botNumber);
                humanStart = true;
            }
        } while(!gameEnd);
    }



    private int choosePlayer(){
        output.askForPlayerNumber();
        int playerNumber = input.getNumber(1,2);
        return playerNumber;
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.easyBot();
    }


}
