package game.ui;

import game.core.EasyBot;
import game.core.board.Board;
import game.core.HumanPlayers;
import game.ui.utilities.Input;
import game.ui.utilities.MenuChoices;
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


    /**
     *
     */
    private void pvpGame(){
        board = new Board();
        boolean gameEnd = false;
        int gameResult;

        do {
            //p1 move
           output.printInfo(board.toString());
           gameResult = board.gameResult();
           if(gameResult == 0){
               playerMove(1);
           } else {
               gameEnd = true;
               output.winnerMessage(2);
           }
           //p2 move
            output.printInfo(board.toString());
            gameResult = board.gameResult();

            if(gameResult == 0){
                playerMove(2);
            } else if(gameResult == -2) {
                gameEnd = true;
                output.drawMessage();
            } else {
                gameEnd = true;
                output.winnerMessage(1);
            }


        } while(!gameEnd);
    }


    /**
     * asks for correct move untill its given
     * @param playerNumber
     * @return
     */
    private boolean playerMove(int playerNumber){
        boolean correctMove = false;
        int move;
        while(!correctMove){
            output.askForMove();
            move = input.getNumber(1,9);
            if(humanPlayers.playerMove(board,move,playerNumber)){
                correctMove = true;
            } else {
                errorMessage.positionTakenMessage();
            }
        }
        return true;
    }

    /**
     * a bit brute force fix but works
     * optimise later
     */
    private void easyBot(){
        easyBot = new EasyBot();
        board = new Board();
        int humanPlayerNumber = choosePlayer();
        // to get the reverse player number
        int botNumber = 3 - humanPlayerNumber;
        boolean humanStart = humanPlayerNumber < botNumber;
        int gameResult;
        boolean gameEnd = false;
        do {
            //p1 move
            if(humanStart){
                output.printInfo(board.toString());
            }
            gameResult = board.gameResult();
            if(humanStart && gameResult == 0) {
                playerMove(humanPlayerNumber);
            } else if (gameResult == -2){
                output.drawMessage();
                gameEnd = true;
            } else if(gameResult == botNumber) {
                output.winnerMessage(botNumber);
                gameEnd = true;
            }
            //p2 move
            gameResult = board.gameResult();
            if(gameResult == 0){
                easyBot.botMove(board,botNumber);
                humanStart = true;
            } else if(gameResult == -2){
                gameEnd = true;
                output.drawMessage();
            } else if(gameResult == humanPlayerNumber){
                gameEnd = true;
                output.printInfo(board.toString());
                output.winnerMessage(humanPlayerNumber);
            }
        } while(!gameEnd);
    }

    private int choosePlayer(){
        output.askForPlayerNumber();
        int playerNumber = input.getNumber(1,2);
        return playerNumber;
    }

    public void menu(){
        boolean exit = false;
        output.welcomeMessage();
        do{
            output.printMenuChoices();
            int menuChoice = input.getNumber(1, MenuChoices.values().length);
            switch (MenuChoices.values()[menuChoice-1]){
                case EXIT:
                    exit = true;
                    output.goodbyeMessage();
                    break;
                case PVP:
                    pvpGame();
                    break;
                case EASY_BOT:
                    easyBot();
                    break;
                default:
                    errorMessage.genericErrorMessage();
            }

        } while(!exit);
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.menu();
    }


}
