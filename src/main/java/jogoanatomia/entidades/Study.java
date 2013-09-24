package jogoanatomia.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Study {
    @JsonProperty
    private String id;

    @JsonProperty
    private String content;

    @JsonProperty("content_url")
    private String contentUrl;

    @JsonProperty("organ_id")
    private String organId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }
}
