package pairmatching.view;

public class OutputView {
    public void printExceptionMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    private enum Message {
        GAME_INTRO("인트로 시작");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
