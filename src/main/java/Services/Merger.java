package Services;

import dto.Question;
import dto.Results;

public interface Merger {
    Results[] examination(Question[][] questions);
}
