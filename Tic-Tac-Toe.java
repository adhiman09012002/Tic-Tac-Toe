import java.util.*;
 class Tic_Tac_Toc {
    private static  void initializeBoard(){
        board = new char[3][3];
        currentPlayer = 'X';
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board.length;j++){
                board[i][j] = '_';
            }
        }
    }
    private static void printBoard(){
        System.out.println("Board:");
        for(int i=0;i< board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void moveOfPlayers(){
        Scanner sc = new Scanner(System.in);
        int row, col;
        while(true){
            System.out.println("Please enter row and col for " + currentPlayer+ " ");

            row = sc.nextInt();
            col = sc.nextInt();

            if(row >=0 && row<=2 && col>=0 && col<=2 && board[row][col]== '_' ){
                board[row][col] = currentPlayer;
                break;
            }
            else{
                System.out.println("Given input is Invalid please try again");
            }
        }
    }

    private static  boolean checkRows(){
        for(int i =0; i<board.length;i++){
            if(board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer ){
                return true;
            }



        }
        return false;
    }

    private static  boolean checkCols(){
        for(int j = 0; j<board.length;j++){
            if(board[0][j]==currentPlayer && board[1][j]==currentPlayer && board[2][j]==currentPlayer){
                return true;
            }


        }
        return false;
    }

    private static boolean checkDiagnals(){
        if((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2]== currentPlayer) ||(board[2][0]==currentPlayer || board[1][1]==currentPlayer || board[0][2]== currentPlayer) ){
            return true;
        }
        return false;
    }

    private static boolean checkForWin(){
        if(checkRows() || checkCols() || checkDiagnals()){
            return true;
        }
        return false;
    }
    private static boolean checkForDrow(){
        for(int i=0;i<= board.length;i++){
            for(int j =0;j<= board.length;j++){
                if (board[i][j] =='_') {

                    return false;
                }
            }
        }
        return true;
    }

    private static void switchPlayer(){
        currentPlayer=(currentPlayer=='X')? '0' : 'X';
    }
    private  static char [][] board;
    private static char currentPlayer;
    public static void main(String [] args){

      initializeBoard();
      printBoard();


        while(true){
            moveOfPlayers();
            printBoard();
            switchPlayer();
            if(checkForWin()){
                System.out.println("Game won by "+ currentPlayer);
                return;
            }
            if(checkForDrow()){
                System.out.println("Game drow");
                return;
            }
        }
    }
}
