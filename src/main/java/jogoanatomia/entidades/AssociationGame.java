package jogoanatomia.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AssociationGame extends Game {
    @JsonProperty("tip_answers")
    private List<TipAnswer> tipAnswers;

    public List<TipAnswer> getTipAnswers() {
        return tipAnswers;
    }

    public void setTipAnswers(List<TipAnswer> tipAnswers) {
        this.tipAnswers = tipAnswers;
    }
}
