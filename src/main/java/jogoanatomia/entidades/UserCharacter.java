package jogoanatomia.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserCharacter {
    @JsonProperty("id")
    private String id;

    @JsonProperty("current_stage")
    private Integer currentStage;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("character_id")
    private String characterId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCurrentStage() {
        return currentStage;
    }

    public void setCurrentStage(Integer currentStage) {
        this.currentStage = currentStage;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCharacterId() {
        return characterId;
    }

    public void setCharacterId(String characterId) {
        this.characterId = characterId;
    }
}
