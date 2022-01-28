package game.ui.utilities;

import java.util.Scanner;

public class Input {

    private Scanner scanner;

    public Input(){
        scanner = new Scanner(System.in);
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
                scanner.nextLine();
            }
            if(number >= minNumber && number <= maxNumber){
                correctNumber = true;
            }
            scanner.nextLine();
        }
        return number;
    }

}
