package com.nhn.academy.view;

/**
 * Message를 저장하는 Enum Class.
 */
public enum Message {

    CHOOSE_PIECE(" O | X 중 하나를 선택해주세요"),
    PRESS_BUTTON("Press 1 : Select O  |  Press 2: Select X"),
    INPUT_ONLY_ONE_TWO("입력은 1 혹은 2 만 가능합니다 !"),
    INPUT_Y_INDEX("체크할 Y 좌표를 입력해 주세요"),
    INPUT_X_INDEX("체크할 X 좌표를 입력해 주세요"),
    RE_INPUT("\n다시 입력해 주세요\n"),

    PLAYER_WIN("Player가 이겼습니다 !!"),
    COMPUTER_WIN("Computer가 이겼습니다 !!"),
    DRAW_GAME("무승부입니다"),
    WRONG_INPUT("잘못된 입력입니다. 입력은 [1~3]의 숫자만 가능합니다");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }


}
