package com.nhn.academy.view;

/**
 * 게임의 Board판을 나타내는 View Class.
 */
public class GameView {

    /**
     * 게임의 Board판을 나타내는 메서드.
     *
     * @param arr 게임의 보드판인 이차원 배열 .
     */
    public static void viewBoard(int[][] arr) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == 0) {
                    System.out.print(" X ");
                } else if (arr[i][j] == 1) {
                    System.out.print(" O ");
                } else {
                    System.out.print("   ");
                }
                if (j <= 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i != 2) {
                System.out.println("---------");
            }
        }


    }

}
