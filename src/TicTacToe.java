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

/**
 * @author devonline
 * @link http://devonline.academy/java-basic
 */
public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("Use the following mapping table to specify a cell using numbers from 1 to 9:");
        printTableMapping();
        if (new Random().nextBoolean()) {
            makeComputerMove();
            printGameTable();
        }
        while (true) {
            makeUserMove();
            printGameTable();
            if (isUserWin()) {
                System.out.println("YOU WIN!");
                break;
            }
            if (isDraw()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            makeComputerMove();
            printGameTable();
            if (isComputerWin()) {
                System.out.println("COMPUTER WIN!");
                break;
            }
            if (isDraw()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
        }
        System.out.println("GAME OVER!");
    }

    private static void printTableMapping() {

    }

    private static void printGameTable() {

    }

    private static void makeUserMove() {

    }

    private static void makeComputerMove() {

    }

    private static boolean isUserWin() {
        return false;
    }

    private static boolean isComputerWin() {
        return false;
    }

    private static boolean isDraw() {
        return false;
    }
}
