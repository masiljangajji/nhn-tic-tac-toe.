package com.nhn.academy.controller;

import com.nhn.academy.model.GameSet;
import com.nhn.academy.view.GameView;
import com.nhn.academy.view.Message;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 게임을 진행시키는 Controller.
 */
public class GameController {

    private static final Logger logger = LoggerFactory.getLogger(GameController.class);
    private static final Scanner sc = new Scanner(System.in);
    /**
     * 입력을 확인하는 정규표현식.
     */
    private static final String stringRegx = "^[1-2]$";

    /**
     * Player기 X 인지 Y인지 입력받음 .
     *
     * @return Player가 선택한 심볼.
     */
    public static String playerChoosePiece() {
        String choosePiece;
        while (true) {
            try {
                logger.info(Message.CHOOSE_PIECE.getMessage());
                logger.info(Message.PRESS_BUTTON.getMessage());

                choosePiece = sc.nextLine();
                if (!Pattern.matches(stringRegx, choosePiece)) {
                    throw new IllegalArgumentException();
                }
                return choosePiece;
            } catch (IllegalArgumentException e) {
                logger.warn(Message.INPUT_ONLY_ONE_TWO.getMessage());
            }
        }
    }

    /**
     * Player가 선턴인 X를 선택했을때 실행 .
     *
     * @param gameSet 게임 진행에 필요한 연산,변수 담고있음.
     */
    public static void playGamePlayerFirst(GameSet gameSet) {

        while (true) {
            String yidx;
            String xidx;

            while (true) {

                logger.info(Message.INPUT_Y_INDEX.getMessage());
                yidx = sc.nextLine();
                logger.info(Message.INPUT_X_INDEX.getMessage());
                xidx = sc.nextLine();

                try {
                    gameSet.setTicTacToeBoard(yidx, xidx, false);
                } catch (IllegalArgumentException e) {
                    logger.warn(Message.RE_INPUT.getMessage());
                    continue;
                }
                break;
            }

            if (gameSet.gameCheck(0)) {
                logger.info(Message.PLAYER_WIN.getMessage());
                break;
            }

            if (gameSet.gameEnd()) {
                logger.info(Message.DRAW_GAME.getMessage());
                break;
            }

            gameSet.setOpponentTicTacToeBoard(true);
            GameView.viewBoard(gameSet.getTieTacToeBoard());

            if (gameSet.gameCheck(1)) {
                logger.info(Message.COMPUTER_WIN.getMessage());
                break;
            }

        }
    }

    /**
     * Computer가 선턴인 X일때 실행 .
     *
     * @param gameSet 게임 진행에 필요한 연산,변수를 담고있음.
     */
    public static void playGameOpponentFirst(GameSet gameSet) {

        while (true) {

            String yidx;
            String xidx;


            gameSet.setOpponentTicTacToeBoard(false);
            GameView.viewBoard(gameSet.getTieTacToeBoard());

            if (gameSet.gameCheck(0)) {
                logger.info(Message.COMPUTER_WIN.getMessage());
                break;
            }

            if (gameSet.gameEnd()) {
                logger.info(Message.DRAW_GAME.getMessage());
                break;
            }

            while (true) {

                logger.info(Message.INPUT_Y_INDEX.getMessage());
                yidx = sc.nextLine();
                logger.info(Message.INPUT_X_INDEX.getMessage());
                xidx = sc.nextLine();

                try {
                    gameSet.setTicTacToeBoard(yidx, xidx, true);
                } catch (IllegalArgumentException e) {
                    logger.warn(Message.RE_INPUT.getMessage());
                    continue;
                }
                break;
            }


            if (gameSet.gameCheck(1)) {
                logger.info(Message.PLAYER_WIN.getMessage());
                break;
            }


        }

    }
}
