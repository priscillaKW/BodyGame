package jogoanatomia.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AssociationGame extends Game {
    public static class TipAnswer {
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

    @JsonProperty("tip_answers")
    private List<TipAnswer> tipAnswers;

    public List<TipAnswer> getTipAnswers() {
        return tipAnswers;
    }

    public void setTipAnswers(List<TipAnswer> tipAnswers) {
        this.tipAnswers = tipAnswers;
    }
}
