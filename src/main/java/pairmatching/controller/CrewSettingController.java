package pairmatching.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.repository.Crews;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class CrewSettingController {
    public static final String BACKEND_SOURCE_PATH = "src/main/resources/backend-crew.md";
    public static final String FRONTEND_SOURCE_PATH = "src/main/resources/frontend-crew.md";

    private final InputView inputView;
    private final OutputView outputView;

    public CrewSettingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        matchingInitialize();
    }

    private void matchingInitialize() {
        try {
            readCrewsFromFile(BACKEND_SOURCE_PATH, Course.BACKEND);
            readCrewsFromFile(FRONTEND_SOURCE_PATH, Course.FRONTEND);
        } catch (IOException exception) {
            outputView.printExceptionMessage(exception);
        }
    }

    private void readCrewsFromFile(String sourcePath, Course course) throws IOException {
        File crews = new File(sourcePath);
        BufferedReader crewReader = new BufferedReader(new FileReader(crews));
        String crewName;
        while ((crewName = crewReader.readLine()) != null) {
            Crews.addCrew(new Crew(course, crewName));
        }
        crewReader.close();
    }
}
