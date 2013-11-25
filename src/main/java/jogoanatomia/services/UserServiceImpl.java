package jogoanatomia.services;

import static java.lang.String.format;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;

import jogoanatomia.entidades.User;
import jogoanatomia.utils.JSONParser;

public class UserServiceImpl implements UserService {
    private ApiClient apiClient;

    public UserServiceImpl() {
        this(new ApiClientImpl());
    }

    public UserServiceImpl(ApiClient client) {
        this.apiClient = client;
    }

    public User create(String username, String password) {
        try {
            Map<String, String> params = new HashMap<String, String>();
            params.put("username", username);
            params.put("password", password);

            HttpResponse response = apiClient.post("/users", JSONParser.toJson(params));

            if (response.getStatusLine().getStatusCode() == 201 && response.getEntity() != null && response.getEntity().getContent() != null)
                return JSONParser.fromHttpResponse(response, User.class);

            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public User login(String username, String password) {
        try {
            Map<String, String> params = new HashMap<String, String>();
            params.put("username", username);
            params.put("password", password);

            HttpResponse response =  apiClient.post("/login", JSONParser.toJson(params));

            if (response.getStatusLine().getStatusCode() == 200 && response.getEntity() != null && response.getEntity().getContent() != null)
                return JSONParser.fromHttpResponse(response, User.class);

            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public User setCharacter(String userId, String kind) {
        try {
            Map<String, String> params = new HashMap<String, String>();
            params.put("kind", kind);

            HttpResponse response =  apiClient.post(format("/users/%s/character", userId), JSONParser.toJson(params));

            if (response.getStatusLine().getStatusCode() == 201 && response.getEntity() != null && response.getEntity().getContent() != null)
                return JSONParser.fromHttpResponse(response, User.class);

            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public User updateCurrentStage(String userId, Integer currentStage) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("current_stage", currentStage);

            HttpResponse response =  apiClient.put(format("/users/%s/character", userId), JSONParser.toJson(params));

            if (response.getStatusLine().getStatusCode() == 200 && response.getEntity() != null && response.getEntity().getContent() != null)
                return JSONParser.fromHttpResponse(response, User.class);

            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
