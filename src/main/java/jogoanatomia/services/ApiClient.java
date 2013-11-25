package jogoanatomia.services;

import org.apache.http.HttpResponse;

public interface ApiClient {
    public HttpResponse get(String path);
    public HttpResponse post(String path, String json);
    public HttpResponse put(String path, String json);
}
