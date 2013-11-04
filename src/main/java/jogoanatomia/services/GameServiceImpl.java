package jogoanatomia.services;

import jogoanatomia.entidades.*;
import jogoanatomia.utils.JSONParser;
import org.apache.http.HttpResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

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
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("score", percentage);
            params.put("organ_id", organId);
            params.put("game_type", type.getSimpleName());

            HttpResponse response = apiClient.post(format("/users/%s/game_scores", userId), JSONParser.toJson(params));

            if (response != null && response.getStatusLine().getStatusCode() != 201)
                System.out.println("something went wrong when update completed percentage");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <T extends Game> Float getCompletedPercentage(String userId, String organId, Class<T> type) {
        try {
            HttpResponse response = apiClient.get(format("/users/%s/game_scores", userId));

            if (response != null && response.getStatusLine().getStatusCode() == 200) {
                List<GameScore> scores = (List<GameScore>) JSONParser.fromHttpResponse(response, List.class, GameScore.class);

                for (GameScore g: scores) {
                    if(g.getOrganId().equals(organId) && g.getGameType().equals(type.getSimpleName()))
                        return g.getScore();
                }
            }

            return 0f;
        } catch (Exception e) {
            return 0f;
        }
    }
}
