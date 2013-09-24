package jogoanatomia.services;

import static java.lang.String.format;

import com.fasterxml.jackson.core.type.TypeReference;
import jogoanatomia.entidades.AssociationGame;
import jogoanatomia.entidades.HangmanGame;
import jogoanatomia.entidades.QuizGame;
import jogoanatomia.entidades.WordSearchesGame;
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
        try {
            HttpResponse response = apiClient.get(format("/organs/%s/games?type=HangmanGame", organId));

            if (response != null && response.getStatusLine().getStatusCode() == 200)
                return JSONParser.fromHttpResponse(response, new TypeReference<List<HangmanGame>>() {});

            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public List<AssociationGame> listAssociationGamesByOrganId(String organId) {
        try {
            HttpResponse response = apiClient.get(format("/organs/%s/games?type=AssociationGame", organId));

            if (response != null && response.getStatusLine().getStatusCode() == 200)
                return JSONParser.fromHttpResponse(response, new TypeReference<List<AssociationGame>>() {});

            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public List<QuizGame> listQuizGamesByOrganId(String organId) {
        try {
            HttpResponse response = apiClient.get(format("/organs/%s/games?type=QuizGame", organId));

            if (response != null && response.getStatusLine().getStatusCode() == 200)
                return JSONParser.fromHttpResponse(response, new TypeReference<List<QuizGame>>() {});

            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public List<WordSearchesGame> listWordSearchesGamesByOrganId(String organId) {
        try {
            HttpResponse response = apiClient.get(format("/organs/%s/games?type=WordSearchesGame", organId));

            if (response != null && response.getStatusLine().getStatusCode() == 200)
                return JSONParser.fromHttpResponse(response, new TypeReference<List<WordSearchesGame>>() {});

            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
