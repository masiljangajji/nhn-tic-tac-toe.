package com.nhn.academy.model;

import com.nhn.academy.view.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.slf4j.LoggerFactory;

/**
 * 게임 진행에 필요한 연산과 변수가 모여있는 Class.
 */
public class GameSet {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(GameSet.class);

    private final String pieceRegex = "^[1-3]$";

    private List<Coordinate> list = new ArrayList<>();

    private final int[][] board;

    public List<Coordinate> getList() {
        return list;
    }


    public int[][] getTieTacToeBoard() {
        return board;
    }

    /**
     * Board판의 값을 초기화 함 .
     *
     * @return 초기화된 Board판.
     */
    public static int[][] makeTicTacToe() {
        return new int[][] {
                {-1, -1, -1},
                {-1, -1, -1},
                {-1, -1, -1}
        };
    }

    /**
     * 좌표가 들어가 있는 list를 설정함.
     *
     * @return 3 x 3 좌표가 들어간 list..
     */
    public static List<Coordinate> makeCoordinateList() {
        List<Coordinate> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                list.add(new Coordinate(i, j));
            }
        }
        return list;
    }

    private void checkPiece(String piece) {
        if (!Pattern.matches(this.pieceRegex, piece)) {
            logger.warn(Message.WRONG_INPUT.getMessage());
            throw new IllegalArgumentException();
        }
    }

    /**
     * Board판에 체크를 함.
     *
     * @param yindex y 좌표.
     * @param xindex x 좌표.
     * @param flag   true - O   falst - X 표시.
     * @return 예외처리를 하기위한 return.
     */
    public boolean setTicTacToeBoard(String yindex, String xindex, boolean flag) {

        checkPiece(yindex);
        checkPiece(xindex);

        int indexX = Integer.parseInt(xindex);
        int indexY = Integer.parseInt(yindex);

        if (board[indexY - 1][indexX - 1] == -1) {
            if (flag) {
                this.board[indexY - 1][indexX - 1] = 1;
            } else {
                this.board[indexY - 1][indexX - 1] = 0;
            }
            deleteTicTacToeBoard(indexY, indexX);
            return true;
        }
        logger.warn("Y " + indexY + " X: " + indexX + " 좌표에는 이미 표시했습니다.");
        throw new IllegalArgumentException();
    }

    public GameSet(int[][] tieTacToeArray, List<Coordinate> list) {
        this.board = tieTacToeArray;
        this.list = list;
    }

    public void deleteTicTacToeBoard(int y, int x) {

        for (int i = 0; i < this.list.size(); i++) {
            Coordinate coordinate = this.list.get(i);
            if (coordinate.getY() == y - 1 && coordinate.getX() == x - 1) {
                this.list.remove(i);
                return;
            }
        }
    }

    /**
     * Coputer가 자동으로 체크 함 .
     * * @param flag   true - O   falst - X  표시..
     */
    public void setOpponentTicTacToeBoard(boolean flag) {
        int number = (int) (Math.random() * (this.list.size()));


        Coordinate coordinate = this.list.get(number);


        if (flag) {
            this.board[coordinate.getY()][coordinate.getX()] = 1;
        } else {
            this.board[coordinate.getY()][coordinate.getX()] = 0;
        }
        this.list.remove(number);

    }

    public boolean gameEnd() {
        return this.list.isEmpty();
    }

    /**
     * 게임의 승리를 확인함 .
     *
     * @param num 확인할 값 .
     * @return 승리했다면 ture 아니라면 False.
     */
    public boolean gameCheck(int num) {

        for (int i = 0; i < this.board.length; i++) {
            if (this.board[i][0] == num && this.board[i][1] == num && this.board[i][2] == num) {
                return true;
            }
        }

        for (int i = 0; i < this.board.length; i++) {
            if (this.board[0][i] == num && this.board[1][i] == num && this.board[2][i] == num) {
                return true;
            }
        }


        if (this.board[0][0] == num && this.board[1][1] == num && this.board[2][2] == num) {
            return true;
        }

        if (this.board[2][0] == num && this.board[1][1] == num && this.board[0][2] == num) {
            return true;
        }


        return false;


    }


}
