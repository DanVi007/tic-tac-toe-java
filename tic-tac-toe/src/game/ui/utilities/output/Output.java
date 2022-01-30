package game.ui.utilities.output;

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


}
