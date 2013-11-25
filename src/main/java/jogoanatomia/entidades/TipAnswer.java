package jogoanatomia.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TipAnswer {
    @JsonProperty
    private String tip;

    @JsonProperty
    private String answer;

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
