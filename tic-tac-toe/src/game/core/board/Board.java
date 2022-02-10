package game.core.board;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dan Vi Trinh
 * board for the game
 * stores all the positions in the game
 */
public class Board {
    private char[] positions;
    public static final int[] ALL_POSITIONS = {0,1,2,3,4,5,6,7,8};
    //not in use only for testing
    private char[] testPositions = {'1','2', '3',
            '4', '5', '6',
            '7','8','9'};
    private char[] boardSymbols;

    private String spaceDividingGuide;

    private String guideLine1;
    private String guideLine2;
    private String guideLine3;
    private String guideLine4;
    private String guideLine5;
    private String guideLine6;
    private String guideLine7;

    public Board() {
        positions = new char[]{' ', ' ', ' ',
                ' ', ' ', ' ',
                ' ', ' ', ' '};
        boardSymbols = new char[]{'X', 'O'};
        spaceDividingGuide = " ".repeat(5);

        guideLine1 = "     |     |     ";
        guideLine2 = "  1  |  2  |  3  ";
        guideLine3 = "-----|-----|-----";
        guideLine4 = "  4  |  5  |  6  ";
        guideLine5 = "-----|-----|-----";
        guideLine6 = "  7  |  8  |  9  ";
        guideLine7 = "     |     |     ";

    }

    /**
     * constructor for ease at testing
     * @param positions
     */
    public Board(char[] positions){
        this.positions = positions;
        boardSymbols = new char[]{'X', 'O'};
        spaceDividingGuide = " ".repeat(5);

        guideLine1 = "     |     |     ";
        guideLine2 = "  1  |  2  |  3  ";
        guideLine3 = "-----|-----|-----";
        guideLine4 = "  4  |  5  |  6  ";
        guideLine5 = "-----|-----|-----";
        guideLine6 = "  7  |  8  |  9  ";
        guideLine7 = "     |     |     ";
    }


    public char[] getPositions(){
        return positions;
    }

    public boolean setPositions(int indexOfPosition, int playerNumber){
        try{
            positions[indexOfPosition] = boardSymbols[playerNumber -1 ];
            return true;
        } catch(IndexOutOfBoundsException e){
            return false;
        }
    }

    /**
     * returns true if position is taken and false if it is not
     * @param position
     * @return
     */
    public boolean positionTaken(int position){
        if(positions[position] != ' '){
            return false;
        }
        return true;
    }

    /**
     * not really necessary,
     * using only set positions is enough
     * @return
     */
    /*
    public ArrayList<Integer> getAvailablePositions(){
        ArrayList<Integer> availablePositions = new ArrayList<>();

        for(int position = 0;position < positions.length; position++){
            if(!positionTaken(position)){
                availablePositions.add(position);
            }
        }

        return availablePositions;
    }
  */





    /**
     * could overide to string aswell
     * @return
     */
    private String formBoard(){
        StringBuilder board = new StringBuilder();
        for(int i = 1; i <8; i ++){
            if(i == 1|| i == 7){
                board.append("     |     |     ");
                board.append(spaceDividingGuide);
                board.append("     |     |     ");
            } else if(i % 2 == 0){
                int positionLine = i/3;
                int firstPositionAtLine = positionLine*3 +1;
                board.append("  " + positions[firstPositionAtLine -1 ] +
                        "  |  "+positions[firstPositionAtLine ]+
                        "  |  " + positions[firstPositionAtLine +1]+ "  ");
                //guide
                board.append(spaceDividingGuide);
                board.append("  " +firstPositionAtLine  +
                        "  |  "+(firstPositionAtLine +1 )+
                        "  |  " + (firstPositionAtLine +2) + "  ");
            } else {
                board.append("-----|-----|-----");
                board.append(spaceDividingGuide);
                board.append("-----|-----|-----");
            }
            board.append("\n");
        }
        return board.toString();
    }

    /**
     * returns who is winning if no one is 0 is returned
     * 2 is p2 winning
     * 1 is p1 winning
     * -2 is draw
     * optimise this later not optimised
     */
    public int gameResult() {
        int winningNumber = 0;
        //checking the rows if there is any one winning on rows
        int index = 0;
        boolean winnerFound = false;
        while(index < 7 && !winnerFound ){
            if(winOnRows(1,index)){
                winningNumber = 1;
                winnerFound = true;
            } else if(winOnRows(2,index)){
                winningNumber = 2;
                winnerFound = true;
            }
            index += 3;
        }
        index = 0;
        //columns
        while (index < 3 && !winnerFound) {
            if (winOnColumns(1,index)) {
                winningNumber = 1;
                winnerFound = true;
            } else if (winOnColumns(2,index)) {
                winningNumber = 2;
                winnerFound = true;
            }
            index++;
        }
        //diagonal
       if(winOnDiagonal(1) && !winnerFound){
           winningNumber = 1;
           winnerFound = true;
       }
       if(winOnDiagonal(2) && !winnerFound){
           winningNumber = 2;
           winnerFound = true;
       }
        //draw
        if(noMoreMoves() && !winnerFound){
            return -2;
        }
        return winningNumber;
    }

    /**
     * checks if player is winning on diagonal
     * @param playerToCheck type in 1 for p1 and 2 for p2
     * @return boolean if the player has won or not
     */
    private boolean winOnDiagonal(int playerToCheck){
        int playerSymbol = playerToCheck - 1;
        if(positions[2] == boardSymbols[playerSymbol]
                && positions[4] == boardSymbols[playerSymbol]
                && positions[6] == boardSymbols[playerSymbol]
                ||(positions[0] == boardSymbols[playerSymbol]
                && positions[4] == boardSymbols[playerSymbol]
                && positions[8] == boardSymbols[playerSymbol])){
            return true;
        }
        return false;
    }

    /**
     * checks if player is winning on a row
     * @param playerToCheck type in 1 for p1 and 2 for p2
     * @param firstIndexInRow the first index of the row to be checked
     * @return boolean if the player has won or not
     */
    private boolean winOnRows(int playerToCheck, int firstIndexInRow) {
        int playerSymbol = playerToCheck - 1;
        int index = firstIndexInRow;
        if (positions[index] == boardSymbols[playerSymbol]
                && positions[index + 1] == boardSymbols[playerSymbol]
                && positions[index + 2] == boardSymbols[playerSymbol]
        ) {
            return true;
        }
        return false;
    }


    /**
     * checks if player is winning on a collum
     * @param playerToCheck type in 1 for p1 and 2 for p2
     * @param firstIndexInCollum the first index of the colum to be checked
     * @return boolean if the player has won or not
     */
    private boolean winOnColumns(int playerToCheck, int firstIndexInCollum){
        int playerSymbol = playerToCheck -1;
        int index = firstIndexInCollum;
        if (positions[index] == boardSymbols[playerSymbol]
                && positions[index + 3] == boardSymbols[playerSymbol]
                && positions[index + 6] == boardSymbols[playerSymbol]) {
            return true;
        }
        return false;
    }

    /**
     * checks if there is any more moves
     * checks if all the positions are filled
     * @return boolean value of whether all the
     *          postions are filled or not.
     */
    private boolean noMoreMoves(){
        boolean empty = false;
        int index = 0;
        while(!empty && index < 9 ){
            if(positions[index] == ' '){
                empty = true;
            }
            index++;
        }
        return !empty;
    }

    @Override
    public String toString() {
        return formBoard();
    }

    public static void main(String[] args) {
        char[] positions = {' ', ' ', ' ',
                'O', 'O', 'O',
                ' ', ' ', ' '};
        Board board = new Board(positions);
        System.out.println(board.positions);
        String brett = board.formBoard();
        System.out.println(brett);

        System.out.println(board.gameResult());


    }

}
