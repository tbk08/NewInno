package Services;

import dto.QuestionInput;
import dto.Result;
import dto.TestResult;

public interface Examination {
    TestResult examination(QuestionInput[][] questions);
}
