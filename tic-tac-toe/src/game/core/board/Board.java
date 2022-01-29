package game.core.board;

/**
 * @author Dan Vi Trinh
 * board for the game
 * stores all the positions in the game
 */
public class Board {
    private char[] positions;

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


    public boolean positionTaken(int position){
        if(positions[position] != ' '){
            return false;
        }
        return true;
    }




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
     * -1 is p2 winning
     * 1 is p1 winning
     * -2 is draw
     * optimise this later not optimesed
     */
    public int gameResult() {

        int winningNumber = 0;
        //checking the rows if there is any one winning on rows
        for (int index = 0; index < 9; index += 3) {
            if (positions[index] == boardSymbols[0]
                    && positions[index + 1] == boardSymbols[0]
                    && positions[index + 2] == boardSymbols[0]
            ) {
                winningNumber = 1;
            } else if (positions[index] == boardSymbols[1]
                    && positions[index + 1] == boardSymbols[1]
                    && positions[index + 2] == boardSymbols[1]) {
                winningNumber = -1;
            }
        }

        boolean foundPosition = false;
        int index = 0;
        while (index < 4 && !foundPosition) {
            if (positions[index] == boardSymbols[0]
                    && positions[index + 3] == boardSymbols[0]
                    && positions[index + 6] == boardSymbols[0]) {
                winningNumber = 1;
                foundPosition = true;
            } else if (positions[index] == boardSymbols[1]
                    && positions[index + 3] == boardSymbols[1]
                    && positions[index + 6] == boardSymbols[1]) {
                winningNumber = -1;
                foundPosition = true;
            }
            index ++;
        }

        if(positions[2] == boardSymbols[0]
                && positions[4] == boardSymbols[0]
        && positions[6] == boardSymbols[0]
        ||(positions[0] == boardSymbols[0]
        && positions[4] == boardSymbols[0]
        && positions[8] == boardSymbols[0])){
            winningNumber = 1;
        }

        if(positions[2] == boardSymbols[1]
                && positions[4] == boardSymbols[1]
                && positions[6] == boardSymbols[1]
                ||(positions[0] == boardSymbols[1]
                && positions[4] == boardSymbols[1]
                && positions[8] == boardSymbols[1])){
            winningNumber = -1;
        }

        if(draw() && winningNumber == 0){
            return -2;
        }

        return winningNumber;
    }

    private boolean draw(){
        boolean draw = true;
        int index = 0;
        while(draw && index < 9 ){
            if(positions[index] == ' '){
                draw = false;
            }
            index++;
        }
        return draw;
    }

    @Override
    public String toString() {
        return formBoard();
    }

    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board.positions);
        String brett = board.formBoard();
        System.out.println(brett);



    }

}
