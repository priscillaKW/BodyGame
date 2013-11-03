package jogoanatomia.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import jogoanatomia.entidades.HangmanGame;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class JSONParser {
    public static String toJson(Object object) {
        try {
            return buildObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            String message = String.format("Error when serializing to json: %s, caused by: %s", object, e);
            throw new RuntimeException(message, e);
        }
    }

    public static <T> T fromHttpResponse(HttpResponse response, Class<T> klass) {
        try {
            return fromJson(readContentFromHttpResponse(response), klass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromHttpResponse(HttpResponse response, TypeReference<T> type) {
        try {
            return fromJson(readContentFromHttpResponse(response), type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Collection<T> fromHttpResponse(HttpResponse response, Class<? extends Collection> c, Class<T> klass) {
        try {
            CollectionType typeFactory = TypeFactory.defaultInstance().constructCollectionType(c, klass);
            return buildObjectMapper().readValue(readContentFromHttpResponse(response), typeFactory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJson(String json, Class<T> klass) {
        try {
            return buildObjectMapper().readValue(json, klass);
        } catch (Exception e) {
            String message = String.format("Error when deserializing from json: %s to: %s, caused by: %s", json, klass, e);
            throw new RuntimeException(message, e);
        }
    }

    public static <T> T fromJson(String json, TypeReference<T> type) {
        try {
            return buildObjectMapper().readValue(json, type);
        } catch (Exception e) {
            String message = String.format("Error when deserializing from json: %s to: %s, caused by: %s", json, type.getType(), e);
            throw new RuntimeException(message, e);
        }
    }

    protected static ObjectMapper buildObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return mapper;
    }

    private static String readContentFromHttpResponse(HttpResponse response) throws IOException {
        return IOUtils.toString(response.getEntity().getContent(), "UTF-8");
    }
}
