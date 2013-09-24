package jogoanatomia.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Game {
    @JsonProperty
    private String id;

    @JsonProperty("organ_id")
    private String organId;

    @JsonProperty
    private Integer score;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
