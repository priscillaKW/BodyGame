package jogoanatomia.services;

import jogoanatomia.entidades.*;

import java.util.List;

public interface GameService {
    public List<HangmanGame> listHangmanGamesByOrganId(String organId);
    public List<AssociationGame> listAssociationGamesByOrganId(String organId);
    public List<QuizGame> listQuizGamesByOrganId(String organId);
    public List<WordSearchesGame> listWordSearchesGamesByOrganId(String organId);
    public <T extends Game> List<T> listGamesByOrganId(String organId, Class<T> type);
    public <T extends Game> void updateCompletedPercentage(String userId, String organId, Float percentage, Class<T> type);
    public <T extends Game> Float getCompletedPercentage(String userId, String organId, Class<T> type);
}
