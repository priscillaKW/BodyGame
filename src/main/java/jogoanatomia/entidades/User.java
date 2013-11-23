package jogoanatomia.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty
    private String id;

    @JsonProperty("username")
    private String login;

    @JsonProperty("password")
    private String password;
    
    @JsonProperty("finish_organ")
    private String finishOrgan;
    
    @JsonProperty("personage")
    private String personage;

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

	public String getFinishOrgan() {
		return finishOrgan;
	}

	public void setFinishOrgan(String finishOrgan) {
		this.finishOrgan = finishOrgan;
	}

	public String getPersonage() {
		return personage;
	}

	public void setPersonage(String personage) {
		this.personage = personage;
	}
    
    
}
