/*
 * Copyright (c) 2019. http://devonline.academy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

import java.util.Random;
import java.util.Scanner;

/**
 * @author devonline
 * @link http://devonline.academy/java-basic
 */
public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("Use the following mapping table to specify a cell using numbers from 1 to 9:");
        printTableMapping();
        char[][] gameTable = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        if (new Random().nextBoolean()) {
            makeComputerMove(gameTable);
            printGameTable(gameTable);
        }
        while (true) {
            makeUserMove(gameTable);
            printGameTable(gameTable);
            if (isUserWin(gameTable)) {
                System.out.println("YOU WIN!");
                break;
            }
            if (isDraw(gameTable)) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            makeComputerMove(gameTable);
            printGameTable(gameTable);
            if (isComputerWin(gameTable)) {
                System.out.println("COMPUTER WIN!");
                break;
            }
            if (isDraw(gameTable)) {
                System.out.println("Sorry, DRAW!");
                break;
            }
        }
        System.out.println("GAME OVER!");
    }

    private static void printTableMapping() {
        char[][] mappingTable = {
                {'7', '8', '9'},
                {'4', '5', '6'},
                {'1', '2', '3'}
        };
        printGameTable(mappingTable);
    }

    private static void printGameTable(char[][] gameTable) {
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + gameTable[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    private static void makeUserMove(char[][] gameTable) {
        while (true) {
            System.out.println("Please type number between 1 and 9:");
            String string = new Scanner(System.in).nextLine();
            if (string.length() == 1) {
                char digit = string.charAt(0);
                if (digit >= '1' && digit <= '9') {
                    if (makeUserMoveToCell(gameTable, digit)) {
                        return;
                    }
                }
            }
        }
    }

    private static boolean makeUserMoveToCell(char[][] gameTable, char digit) {
        char[][] mappingTable = {
                {'7', '8', '9'},
                {'4', '5', '6'},
                {'1', '2', '3'}
        };
        for (int i = 0; i < mappingTable.length; i++) {
            for (int j = 0; j < mappingTable[i].length; j++) {
                if (mappingTable[i][j] == digit) {
                    if (gameTable[i][j] == ' ') {
                        gameTable[i][j] = 'X';
                        return true;
                    } else {
                        System.out.println("Can't make a move, because the cell is not free! Try again!");
                        return false;
                    }
                }
            }
        }
        return false;
    }

    private static void makeComputerMove(char[][] gameTable) {
        Random random = new Random();
        while (true) {
            int row = random.nextInt(3);
            int col = random.nextInt(3);
            if (gameTable[row][col] == ' ') {
                gameTable[row][col] = 'O';
                return;
            }
        }
    }

    private static boolean isUserWin(char[][] gameTable) {
        return isWinner(gameTable, 'X');
    }

    private static boolean isComputerWin(char[][] gameTable) {
        return isWinner(gameTable, 'O');
    }

    private static boolean isWinner(char[][] gameTable, char ch) {
        for (int i = 0; i < 3; i++) {
            if (gameTable[i][0] == gameTable[i][1] && gameTable[i][0] == gameTable[i][2] && gameTable[i][0] == ch) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (gameTable[0][i] == gameTable[1][i] && gameTable[0][i] == gameTable[2][i] && gameTable[0][i] == ch) {
                return true;
            }
        }
        if (gameTable[0][0] == gameTable[1][1] && gameTable[0][0] == gameTable[2][2] && gameTable[0][0] == ch) {
            return true;
        }
        if (gameTable[0][2] == gameTable[1][1] && gameTable[0][2] == gameTable[2][0] && gameTable[0][2] == ch) {
            return true;
        }
        return false;
    }

    private static boolean isDraw(char[][] gameTable) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameTable[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
