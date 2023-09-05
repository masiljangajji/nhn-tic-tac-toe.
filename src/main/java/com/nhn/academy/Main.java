package com.nhn.academy;

import com.nhn.academy.controller.GameController;
import com.nhn.academy.model.GameSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 게임이 시작되는 Main Class.
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     *  게임이 시작되는 Main 메서드.
     */
    public static void main(String[] args) {

        logger.info("tic-tac-toe 게임을 시작합니다 ");

        String choosePiece = GameController.playerChoosePiece();
        GameSet gameSet = new GameSet(GameSet.makeTicTacToe(), GameSet.makeCoordinateList());

        if (choosePiece.equals("2")) {
            GameController.playGamePlayerFirst(gameSet);
        } else {
            GameController.playGameOpponentFirst(gameSet);
        }

        logger.info("게임 종료");

    }


}
