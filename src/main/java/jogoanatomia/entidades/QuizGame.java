package jogoanatomia.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuizGame extends Game {
    @JsonProperty
    private String question;

    @JsonProperty("option_a")
    private String optionA;

    @JsonProperty("option_b")
    private String optionB;

    @JsonProperty("option_c")
    private String optionC;

    @JsonProperty("option_d")
    private String optionD;

    @JsonProperty
    private String answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
