package jogoanatomia.services;

import jogoanatomia.entidades.User;
import jogoanatomia.utils.JSONParser;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.HashMap;
import java.util.Map;

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
}
