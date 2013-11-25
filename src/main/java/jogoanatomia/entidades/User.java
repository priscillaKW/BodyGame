package jogoanatomia.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    public static class Character {
        @JsonProperty("kind")
        private String kind;

        @JsonProperty("current_stage")
        private Integer currentStage;

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public Integer getCurrentStage() {
            return currentStage == null ? -1 : currentStage;
        }

        public void setCurrentStage(Integer currentStage) {
            this.currentStage = currentStage;
        }
    }

    @JsonProperty
    private String id;

    @JsonProperty("username")
    private String login;

    @JsonProperty("password")
    private String password;

    @JsonProperty("character")
    private Character character;

    public Integer currentStage() {
        return getCharacter() != null ? getCharacter().getCurrentStage() : -1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
