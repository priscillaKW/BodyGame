package jogoanatomia.services;

import static java.lang.String.format;

import com.fasterxml.jackson.core.type.TypeReference;
import jogoanatomia.entidades.Study;
import jogoanatomia.utils.JSONParser;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;

import java.util.List;

public class StudyServiceImpl implements StudyService {
    private ApiClient apiClient;

    public StudyServiceImpl() {
        this(new ApiClientImpl());
    }

    public StudyServiceImpl(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public List<Study> listByOrganId(String organId) {
        try {
            HttpResponse response = apiClient.get(format("/organs/%s/studies", organId));

            if (response != null && response.getStatusLine().getStatusCode() == 200)
                return JSONParser.fromJson(IOUtils.toString(response.getEntity().getContent(), "UTF-8"), new TypeReference<List<Study>>() {});

            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Study find(String id) {
        try {
            HttpResponse response = apiClient.get(format("/studies/%s", id));

            if (response != null && response.getStatusLine().getStatusCode() == 200)
                return JSONParser.fromJson(IOUtils.toString(response.getEntity().getContent(), "UTF-8"), Study.class);

            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
