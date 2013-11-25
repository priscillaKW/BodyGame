package jogoanatomia.services;

import static java.lang.String.format;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.UnsupportedEncodingException;

public class ApiClientImpl implements ApiClient {
    public HttpResponse get(String path) {
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet get = new HttpGet(buildUrl(path));
            get.setHeader("Accept", "application/json");

            return httpClient.execute(get);
        } catch (Exception e) {
           return null;
        }
    }

    public HttpResponse post(String path, String json) {
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost post = new HttpPost(buildUrl(path));
            post.setEntity(buildEntity(json));

            return httpClient.execute(post);
        } catch (Exception e) {
            return null;
        }
    }

    public HttpResponse put(String path, String json) {
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPut put = new HttpPut(buildUrl(path));
            put.setEntity(buildEntity(json));

            return httpClient.execute(put);
        } catch (Exception e) {
            return null;
        }
    }

    private StringEntity buildEntity(String json) throws UnsupportedEncodingException {
        StringEntity entity = new StringEntity(json, "UTF-8");
        entity.setContentType("application/json");

        return entity;
    }

    private String buildUrl(String path) {
        return format("%s%s", getEndPoint(), path);
    }

    private String getEndPoint() {
       return "http://bodygame-api-dev.herokuapp.com"; // TODO: retrieve from config file
    }
}
