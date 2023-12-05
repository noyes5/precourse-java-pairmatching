package pairmatching.view;

import static com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text.NEW_LINE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import pairmatching.domain.command.MainCommand;
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
        List<String> paringInfo = getParingInfo();
        return paringInfo;
    }

    private static List<String> getParingInfo() {
        return StringUtils.splitByComma(Console.readLine());
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
                + "############################################");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }

}
