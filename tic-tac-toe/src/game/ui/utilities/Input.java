package game.ui.utilities;



import game.ui.utilities.output.ErrorMessage;

import java.util.Scanner;

public class Input {

    private Scanner scanner;
    private ErrorMessage message;

    public Input(){
        scanner = new Scanner(System.in);
        message = new ErrorMessage();
    }

    /**c
     * check if works and fix
     * @param minNumber
     * @param maxNumber
     * @return
     */
    public int getNumber(int minNumber, int maxNumber){
        int number = -1000;
        boolean correctNumber = false;
        while(!correctNumber){
            if(scanner.hasNextInt()){
                number = scanner.nextInt();
            } else {
                message.notANumber();
                scanner.nextLine();
            }
            if(number >= minNumber && number <= maxNumber){
                correctNumber = true;
            } else {
                message.invalidNumber(minNumber,maxNumber);
            }
            scanner.nextLine();
        }
        return number;
    }

}
