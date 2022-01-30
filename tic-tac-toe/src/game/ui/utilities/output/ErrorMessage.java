package game.ui.utilities.output;

public class ErrorMessage {
    public ErrorMessage(){

    }

    public void notANumber(){
        System.err.println("No number was registered ");
    }

    public void invalidNumber(int minNumber, int maxNumber){
        System.err.println("Please enter a number between " + minNumber +
                " and " + maxNumber);
    }

    public void genericErrorMessage(){
        System.err.println("Something went wrong ");
    }

}
