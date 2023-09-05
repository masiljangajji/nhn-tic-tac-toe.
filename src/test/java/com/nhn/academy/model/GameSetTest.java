package com.nhn.academy.model;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameSetTest {

    GameSet gameSet;

    @BeforeEach
    void setTest() {
        gameSet = new GameSet(GameSet.makeTicTacToe(), GameSet.makeCoordinateList());
    }

    // Set

    @Test
    @DisplayName("SetTicTacToeBoard Test 중복인 경우")
    void setTicTacToeBoardTest() {

        gameSet.setTicTacToeBoard("1", "1", true);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                gameSet.setTicTacToeBoard("1", "1", true));

        gameSet.setTicTacToeBoard("2", "2", false);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                gameSet.setTicTacToeBoard("2", "2", false));
    }

    @Test
    @DisplayName("SetTicTacToeBoard Test 정상인 경우")
    void setTicTacToeBoardTest2() {

        gameSet.setTicTacToeBoard("1", "1", true);
        gameSet.setTicTacToeBoard("2", "2", false);
        int[][] arr = gameSet.getTieTacToeBoard();

        Assertions.assertEquals(arr[0][0], 1);
        Assertions.assertEquals(arr[1][1], 0);

    }

    // Delete
    @Test
    @DisplayName("DeleteTicTacToeBoard Test ")
    void deleteTicTacToeBoardTest() {

        gameSet.setTicTacToeBoard("1", "2", true);
        gameSet.deleteTicTacToeBoard(1, 2);

        Assertions.assertEquals(8, gameSet.getList().size());

        List<Coordinate> list = gameSet.getList();

        Optional<Coordinate> coordinate = list.stream()
                .filter(x -> x.getY() == 0)
                .filter(x -> x.getX() == 1)
                .findFirst();

        Assertions.assertEquals(coordinate.isEmpty(), true);

    }


    // gameEnd
    @Test
    @DisplayName("GameEnd Test 모든 list 삭제")
    void gameEndTest() {

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                gameSet.deleteTicTacToeBoard(i, j);
            }
        }
        Assertions.assertEquals(gameSet.gameEnd(), true);
    }

    // gameCheck
    @Test
    @DisplayName("GameCheck Test X방향 체크 true")
    void gameCheckTest() {

        gameSet.setTicTacToeBoard("1", "1", true);
        gameSet.setTicTacToeBoard("1", "2", true);
        gameSet.setTicTacToeBoard("1", "3", true);
        Assertions.assertEquals(gameSet.gameCheck(1), true);
    }

    @Test
    @DisplayName("GameCheck Test X방향 체크 false")
    void gameCheckTest2() {

        gameSet.setTicTacToeBoard("1", "1", false);
        gameSet.setTicTacToeBoard("1", "2", false);
        gameSet.setTicTacToeBoard("1", "3", false);
        Assertions.assertEquals(gameSet.gameCheck(0), true);
    }

    @Test
    @DisplayName("GameCheck Test Y방향 체크 true")
    void gameCheckTest3() {

        gameSet.setTicTacToeBoard("1", "1", true);
        gameSet.setTicTacToeBoard("2", "1", true);
        gameSet.setTicTacToeBoard("3", "1", true);
        Assertions.assertEquals(gameSet.gameCheck(1), true);


    }

    @Test
    @DisplayName("GameCheck Test Y방향 체크 false")
    void gameCheckTest4() {
        gameSet.setTicTacToeBoard("3", "2", false);
        gameSet.setTicTacToeBoard("1", "2", false);
        gameSet.setTicTacToeBoard("2", "2", false);
        Assertions.assertEquals(gameSet.gameCheck(0), true);
    }

    @Test
    @DisplayName("GameCheck Test 내려가는 대각선 체크 true")
    void gameCheckTest5() {

        gameSet.setTicTacToeBoard("2", "2", true);
        gameSet.setTicTacToeBoard("3", "3", true);
        gameSet.setTicTacToeBoard("1", "1", true);

        Assertions.assertEquals(gameSet.gameCheck(1), true);
    }

    @Test
    @DisplayName("GameCheck Test 내려가는 대각선 체크 false")
    void gameCheckTest6() {

        gameSet.setTicTacToeBoard("1", "1", false);
        gameSet.setTicTacToeBoard("3", "3", false);
        gameSet.setTicTacToeBoard("2", "2", false);

        Assertions.assertEquals(gameSet.gameCheck(0), true);
    }

    @Test
    @DisplayName("GameCheck Test  올라가는 대각선 체크 true")
    void gameCheckTest7() {
        gameSet.setTicTacToeBoard("1", "3", true);
        gameSet.setTicTacToeBoard("3", "1", true);
        gameSet.setTicTacToeBoard("2", "2", true);
        Assertions.assertEquals(gameSet.gameCheck(1), true);
    }

    @Test
    @DisplayName("GameCheck Test  올라가는 대각선 체크 false")
    void gameCheckTest8() {
        gameSet.setTicTacToeBoard("2", "2", false);
        gameSet.setTicTacToeBoard("3", "1", false);
        gameSet.setTicTacToeBoard("1", "3", false);
        Assertions.assertEquals(gameSet.gameCheck(0), true);
    }

}