package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.command.MainCommand;
import pairmatching.util.InputValidator;

public class InputView {

    public String readMainOption() {
        MainCommand.getFormatedList().forEach(System.out::println);
        String input = Console.readLine();
        InputValidator.validateInput(input);
        return input;
    }

    private enum Message {
        GAME_INTRO("인트로 시작");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }

}
