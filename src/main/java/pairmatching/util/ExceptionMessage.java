package pairmatching.util;

public enum ExceptionMessage {
    ERROR_MAIN_COMMAND("올바른 번호를 입력해주세요."),
    INVALID_CREW_NAME("해당하는 크루 이름이 없습니다."),
    INVALID_COMMAND("입력값이 잘못되었습니다."),
    INVALID_COURSE_NAME("해당하는 코스명이 없습니다."),
    INVALID_LEVEL_NAME("해당하는 레벨명이 없습니다."),
    INVALID_INPUT_BLANK("빈 값은 입력할수 없습니다."),
    INVALID_REMATCH_ATTEMPTS("3번 까지만 재매칭할 수 있습니다."),
    NO_MISSION_IN_LEVEL("미션이 해당하는 레벨에 없습니다."),
    NO_MATCH_HISTORY("매칭 이력이 없습니다.");

    private String message;
    private static final String BASE_MESSAGE = "[ERROR] %s";

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
