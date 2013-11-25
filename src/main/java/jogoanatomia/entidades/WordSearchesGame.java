package jogoanatomia.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WordSearchesGame extends Game {
    @JsonProperty
    private List<TipAnswer> words;

    public List<TipAnswer> getWords() {
        return words;
    }

    public void setWords(List<TipAnswer> words) {
        this.words = words;
    }
}
