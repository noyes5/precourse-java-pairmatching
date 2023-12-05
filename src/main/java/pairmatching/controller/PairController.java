package pairmatching.controller;

import java.util.EnumMap;
import java.util.Map;
import jdk.jfr.internal.tool.Main;
import pairmatching.domain.command.MainCommand;
import pairmatching.util.DataInputHandler;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Map<MainCommand, ControllerHandler > controllers;

    public PairController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        controllers = new EnumMap<>(MainCommand.class);
        crewSetting();
        initializeController();
    }

    private void crewSetting() {
        new CrewSettingController(outputView);
    }

    private void initializeController() {
        controllers.put(MainCommand.PAIR_MATCHING, new PairMatchingController(inputView, outputView));
        controllers.put(MainCommand.PAIR_SEARCHING, new PairSearchingController(inputView, outputView));
        controllers.put(MainCommand.PAIR_INITIALIZING, new PairInitializeController(inputView, outputView));
        controllers.put(MainCommand.APPLICATION_EXIT, new ApplicationExitController(inputView, outputView));

    }

    public void play() {
        MainCommand mainCommand;
        do {
            mainCommand = inputMainCommand();
            progress(mainCommand);
        } while (mainCommand.isPlayable());
    }

    private MainCommand inputMainCommand() {
        while (true) {
            try {
                return inputView.readMainCommand();
            } catch (IllegalArgumentException exception) {
                outputView.printExceptionMessage(exception);
            }
        }
    }

    private void progress(MainCommand mainCommand) {
        controllers.get(mainCommand).process();
    }
}
