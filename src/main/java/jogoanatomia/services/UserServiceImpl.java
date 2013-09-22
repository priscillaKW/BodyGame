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
    @Override
    public User create(String username, String password) {
        try {
            Map<String, String> params = new HashMap<String, String>();
            params.put("username", username);
            params.put("password", password);

            HttpClient httpClient = new DefaultHttpClient();
            HttpPost post = new HttpPost("http://bodygame-api-dev.herokuapp.com/users");
            StringEntity entity = new StringEntity(JSONParser.toJson(params), "UTF-8");
            entity.setContentType("application/json");
            post.setEntity(entity);
            HttpResponse response =  httpClient.execute(post);

            if (response.getStatusLine().getStatusCode() == 201 && response.getEntity() != null && response.getEntity().getContent() != null)
                return JSONParser.fromJson(IOUtils.toString(response.getEntity().getContent(), "UTF-8"), User.class);

            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public User login(String username, String password) {
        try {
            Map<String, String> params = new HashMap<String, String>();
            params.put("username", username);
            params.put("password", password);

            HttpClient httpClient = new DefaultHttpClient();
            HttpPost post = new HttpPost("http://bodygame-api-dev.herokuapp.com/login");
            StringEntity entity = new StringEntity(JSONParser.toJson(params), "UTF-8");
            entity.setContentType("application/json");
            post.setEntity(entity);
            HttpResponse response =  httpClient.execute(post);

            if (response.getStatusLine().getStatusCode() == 200 && response.getEntity() != null && response.getEntity().getContent() != null)
                return JSONParser.fromJson(IOUtils.toString(response.getEntity().getContent(), "UTF-8"), User.class);

            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
