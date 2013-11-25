package jogoanatomia.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Character {
    @JsonProperty("id")
    private String id;

    @JsonProperty("kind")
    private String kind;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
