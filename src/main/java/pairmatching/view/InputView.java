package pairmatching.view;

import static pairmatching.util.Constants.NEW_LINE;
import static pairmatching.util.ExceptionMessage.INVALID_COMMAND;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import pairmatching.domain.command.MainCommand;
import pairmatching.domain.command.RematchCommand;
import pairmatching.util.InputValidator;
import pairmatching.util.StringUtils;

public class InputView {

    public MainCommand readMainCommand() {
        MainCommand.getFormatedList().forEach(System.out::println);
        String input = Console.readLine();
        InputValidator.validateInput(input);
        return MainCommand.from(input);
    }

    public List<String> readParingInfo() {
        System.out.println(Message.INPUT_PAIR_COMMAND.message);
        return getParingInfo();
    }

    private static List<String> getParingInfo() {
        List<String> inputParingInfo = StringUtils.splitByComma(Console.readLine());
        InputValidator.validateParingInput(inputParingInfo);
        return inputParingInfo;
    }

    public RematchCommand readRematchCommand() {
        System.out.println(Message.INPUT_REMATCH.message);
        String input = Console.readLine();
        InputValidator.validateRematch(input);
        return RematchCommand.from(input);
    }

    private enum Message {
        INPUT_PAIR_COMMAND("#############################################" + NEW_LINE
                + "과정: 백엔드 | 프론트엔드" + NEW_LINE
                + "미션:" + NEW_LINE
                + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임" + NEW_LINE
                + "  - 레벨2: 장바구니 | 결제 | 지하철노선도" + NEW_LINE
                + "  - 레벨3:" + NEW_LINE
                + "  - 레벨4: 성능개선 | 배포" + NEW_LINE
                + "  - 레벨5:" + NEW_LINE
                + "############################################"),
        INPUT_REMATCH("매칭 정보가 있습니다. 다시 매칭하시겠습니까?" + NEW_LINE
                + "네 | 아니오");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }

}
