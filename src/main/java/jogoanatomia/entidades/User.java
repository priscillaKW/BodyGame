package jogoanatomia.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty
    private String id;

    @JsonProperty("username")
    private String login;

    @JsonProperty("password")
    private String password;

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
}
