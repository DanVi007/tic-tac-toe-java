package game.ui.utilities.output;

import game.ui.utilities.MenuChoices;

public class Output {
    public Output(){

    }

    public void printInfo(String info){
        System.out.println(info);
    }

    public void askForMove(){
        System.out.println("Please enter in a number for the position to play ");
    }

    public void drawMessage(){
        System.out.println("The game is a draw ");
    }

    public void winnerMessage(int playerWinner){
        System.out.println("Congratulations p" + playerWinner + " has won");
    }

    public void askForPlayerNumber(){
        System.out.println("Do you want to be player 1 or 2? ");
        System.out.println("player 1 = X , player 2 = O");
    }

    /**
     * idk what i did fix/optimise later
     */
    public void printMenuChoices(){

        int index = 0;
        while(index < MenuChoices.values().length){
            System.out.println("Press "
            + (index+1) +" for "
                    + MenuChoices.values()[index]);
            index++;
        }
    }

    public void welcomeMessage(){
        System.out.println("Welcome to tic tac toe, you have the following options:");

    }

    public void goodbyeMessage(){
        System.out.println("Thank you for playing with us, goodbye! ");
    }

}
