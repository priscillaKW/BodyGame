package jogoanatomia.services;

import jogoanatomia.entidades.AssociationGame;
import jogoanatomia.entidades.HangmanGame;
import jogoanatomia.entidades.QuizGame;
import jogoanatomia.entidades.WordSearchesGame;

import java.util.List;

public interface GameService {
    public List<HangmanGame> listHangmanGamesByOrganId(String organId);
    public List<AssociationGame> listAssociationGamesByOrganId(String organId);
    public List<QuizGame> listQuizGamesByOrganId(String organId);
    public List<WordSearchesGame> listWordSearchesGamesByOrganId(String organId);
}
