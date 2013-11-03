package jogoanatomia.entidades.actor;

import java.util.ArrayList;
import java.util.List;

import jogoanatomia.entidades.Organ;
import jogoanatomia.entidades.User;
import jogoanatomia.entidades.WordSearchesGame;
import jogoanatomia.services.GameService;
import jogoanatomia.services.GameServiceImpl;

public class CacaPalavraActor extends StageGameActor<WordSearchesGame> {
    private int faltaEncontrar;

    public CacaPalavraActor(GameService service, User user, Organ organ) {
        super(service, user, organ);
    }

    public int getFaltaEncontrar() {
        return faltaEncontrar;
    }

    public void setFaltaEncontrar(int faltaEncontrar) {
        this.faltaEncontrar = faltaEncontrar;
    }

    public int[] sorteiaPosicao() {
        int[] resp = new int[3];
        int x = (int) (Math.random() * 20);
        int y = (int) (Math.random() * 20);
        //0-horizontal __ 1-vertical
        int d = (int) (Math.random() * 2);
        resp[0] = x;
        resp[1] = y;
        resp[2] = d;
        return resp;
    }

    @Override
    void afterSelectNextStage(WordSearchesGame stage) {
        setFaltaEncontrar(stage.getWords().size());
    }

    @Override
    Class<WordSearchesGame> getGameType() {
        return WordSearchesGame.class;
    }
}
