package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        char[][] tictac = new char[3][3];


        for(int i = 0; i < 3 ; i++) {
            for(int j = 0 ; j< 3 ;j++) {
                tictac[i][j] = '_';
            }
        }


        printTickTak(tictac);


        int start = 0;

        while (true) {

            boolean checkInput = false;
            String[] str2 = new String[2];


            while ( checkInput != true ) {
                System.out.print("Enter the coordinates: ");
                str2[0] = scanner.next();
                str2[1] = scanner.next();
                checkInput = checkInput(tictac , str2);
            }
            tictac[Integer.valueOf(str2[0])-1][Integer.valueOf(str2[1])-1] = (start == 0 ? 'X' : 'O');
            start = (start == 0 ? 1 : 0);
            printTickTak(tictac);

            char ch = (start == 0 ? 'O' : 'X');
            if(checkWins(tictac)) {
                System.out.println(ch + " wins");
                break;
            }
            if(!checkEmpty(tictac)) {
                System.out.println("DRAW");
                break;
            }

        }




    }


    public static void printTickTak(char[][] tictac) {

        System.out.println("---------");
        for(int i = 0 ; i< 3  ; i++) {
            System.out.print("| ");
            for(int j =  0 ; j < 3 ; j++) {
                System.out.print(tictac[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static boolean checkWins(char[][] tictac) {

        int count = 0;
        char ch = '_';
        for(int i = 0 ;i < 3 ;i++) {

            if( (tictac[i][0] == tictac[i][1] ) && (tictac[i][0] == tictac[i][2]) && tictac[i][0] != '_') {
                if(count == 0) {
                    ch = tictac[i][0];
                    count++;
                }
                else {
                    if(tictac[i][0] != ch) {
                        count++;
                    }
                }
            }
            if( (tictac[0][i] == tictac[1][i] ) && (tictac[0][i] == tictac[2][i]) && tictac[0][i] != '_') {
                if(count == 0) {
                    ch = tictac[0][i];
                    count++;
                }
                else {
                    if(tictac[0][i] != ch) {
                        count++;
                    }
                }
            }
        }

        if( (tictac[0][0] == tictac[1][1] ) && (tictac[0][0] == tictac[2][2]) && tictac[0][0] != '_') {
            if(count == 0) {
                ch = tictac[0][0];
                count++;
            }
            else {
                if(tictac[0][0] != ch) {
                    count++;
                }
            }
        }
        if( (tictac[0][2] == tictac[1][1] ) && (tictac[0][2] == tictac[2][0]) && tictac[0][2] != '_') {
            if(count == 0) {
                ch = tictac[0][2];
                count++;
            }
            else {
                if(tictac[0][2] != ch) {
                    count++;
                }
            }
        }

        if(count == 1) {

            return true;
        }
        if(count > 1) {
            System.out.println("Impossible");
            return true;
        }

        return false;
    }

    public static boolean checkEmpty(char[][] tictac) {

        for(int i = 0 ; i < 3 ; i++) {
            for(int j = 0 ; j < 3 ;j++) {
                if(tictac[i][j] =='_') {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean checkImpossible(char[][] tictac) {

        int count1 = 0;
        int count2 = 0;

        for(int i = 0 ; i < 3 ;i++ ) {
            for(int j = 0 ; j < 3 ;j++) {
                if(tictac[i][j] == 'X') {
                    count1++;
                }
                if(tictac[i][j] == 'O') {
                    count2++;
                }
            }
        }

        if(Math.abs(count1-count2) > 1) {
            System.out.println("Impossible");
            return true;
        }


        return false;
    }

    public static boolean analyseGame(char[][] tictac) {

        if(checkImpossible(tictac)) {
            return true;
        }
        if (checkWins(tictac)) {
            return true;
        }
        if(checkEmpty(tictac)){
            System.out.println("Game not finished");
            return true;
        }
        else {
            System.out.println("Draw");
            return true;
        }



    }

    public static boolean checkInput(char[][] tictac , String[] str) {

       for(int i = 0 ; i < str.length;i++) {
           for(int j = 0 ; j < str[i].length() ;j++) {
               if(!Character.isDigit(str[i].charAt(j))) {
                   System.out.println("You should enter numbers!");
                   return false;
               }
           }
       }

       for(int i = 0 ; i < str.length ;i++) {
           int n = Integer.valueOf(str[i]);
           if( n > 3 ||  n < 1) {
               System.out.println("Coordinates should be from 1 to 3!");
               return false;
           }
       }

       int n = Integer.valueOf(str[0]);
       int m = Integer.valueOf(str[1]);

       if(tictac[n-1][m-1] != '_') {
           System.out.println("This cell is occupied! Choose another one!");
           return false;
       }

       return true;
    }
}
