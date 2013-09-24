package jogoanatomia.services;

import com.fasterxml.jackson.core.type.TypeReference;
import jogoanatomia.entidades.Organ;
import jogoanatomia.utils.JSONParser;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;

import java.util.List;

public class OrganServiceImpl implements OrganService {
    private ApiClient apiClient;

    public OrganServiceImpl() {
        this(new ApiClientImpl());
    }

    public OrganServiceImpl(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public List<Organ> all() {
        try {
            HttpResponse response = apiClient.get("/organs");

            if (response.getStatusLine().getStatusCode() == 200)
                return JSONParser.fromJson(IOUtils.toString(response.getEntity().getContent(), "UTF-8"), new TypeReference<List<Organ>>() {});

            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
