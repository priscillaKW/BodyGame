package jogoanatomia.entidades.actor;

import java.util.ArrayList;
import java.util.List;
import jogoanatomia.entidades.WordSearchesGame;
import jogoanatomia.services.GameServiceImpl;

public class CacaPalavraActor {
    
    ArrayList<WordSearchesGame> fasesCacaPalavras;
    public GameServiceImpl game;
    
    private int pontuacaoTotal = 0;
    private int faltaEncontrar;
    
    
    public void sorteiaFases(String idOrgao) {
        game = new GameServiceImpl();
        List<WordSearchesGame> todas = game.listWordSearchesGamesByOrganId(idOrgao);
        fasesCacaPalavras = (ArrayList<WordSearchesGame>) todas;
    }
    
    public WordSearchesGame getProxFase(int i) {
        if(fasesCacaPalavras.size()>i){
            setFaltaEncontrar(fasesCacaPalavras.get(i).getWords().size());
            return fasesCacaPalavras.get(i);
        }
        return null;
    }

    public int getFaltaEncontrar() {
        return faltaEncontrar;
    }

    public void setFaltaEncontrar(int faltaEncontrar) {
        this.faltaEncontrar = faltaEncontrar;
    }

    public int getPontuacaoTotal() {
        return pontuacaoTotal;
    }

    public void setPontuacaoTotal(int pontuacaoTotal) {
        this.pontuacaoTotal += pontuacaoTotal;
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
    
    
    
    
}
