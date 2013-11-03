package jogoanatomia.services;

import static java.lang.String.format;

import com.fasterxml.jackson.core.type.TypeReference;
import jogoanatomia.entidades.*;
import jogoanatomia.utils.JSONParser;
import org.apache.http.HttpResponse;

import java.util.List;

public class GameServiceImpl implements GameService {
    private ApiClient apiClient;

    public GameServiceImpl() {
        this(new ApiClientImpl());
    }

    public GameServiceImpl(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public List<HangmanGame> listHangmanGamesByOrganId(String organId) {
        return listGamesByOrganId(organId, HangmanGame.class);
    }

    public List<AssociationGame> listAssociationGamesByOrganId(String organId) {
        return listGamesByOrganId(organId, AssociationGame.class);
    }

    public List<QuizGame> listQuizGamesByOrganId(String organId) {
        return listGamesByOrganId(organId, QuizGame.class);
    }

    public List<WordSearchesGame> listWordSearchesGamesByOrganId(String organId) {
        return listGamesByOrganId(organId, WordSearchesGame.class);
    }

    public <T extends Game> List<T> listGamesByOrganId(String organId, Class<T> type) {
        try {
            HttpResponse response = apiClient.get(format("/organs/%s/games?type=%s", organId, type.getSimpleName()));

            if (response != null && response.getStatusLine().getStatusCode() == 200)
                return (List<T>) JSONParser.fromHttpResponse(response, List.class, type);

            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public <T extends Game> void updateCompletedPercentage(String userId, String organId, Float percentage, Class<T> type) {
        // TODO
    }

    public <T extends Game> Float getCompletedPercentage(String userId, String organId, Class<T> type) {
        // TODO
        return 0f;
    }
}
