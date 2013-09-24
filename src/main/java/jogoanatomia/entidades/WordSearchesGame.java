package jogoanatomia.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WordSearchesGame extends Game {
    @JsonProperty
    private List<String> words;

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }
}
