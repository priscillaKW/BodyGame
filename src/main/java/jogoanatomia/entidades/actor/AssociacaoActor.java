package jogoanatomia.entidades.actor;

import java.util.ArrayList;
import java.util.List;
import jogoanatomia.entidades.AssociationGame;
import jogoanatomia.entidades.WordSearchesGame;
import jogoanatomia.services.GameServiceImpl;

public class AssociacaoActor {
    
    ArrayList<AssociationGame> fasesAssociacao;
    public GameServiceImpl game;
    
    public int pontuacaoTotal=0;
    public ArrayList<AssociationGame.TipAnswer> fasesOriginal;
    public ArrayList<AssociationGame.TipAnswer> fasesEmbaralhadas;
    public ArrayList<Integer> ordemRespostas;
    
    public void sorteiaFases(String idOrgao){
        game = new GameServiceImpl();
        List<AssociationGame> todas = game.listAssociationGamesByOrganId(idOrgao);
        fasesAssociacao = (ArrayList<AssociationGame>) todas;
    }
    
    public AssociationGame getProxFase(int i) {
        if(fasesAssociacao.size()>i){
            fasesOriginal = (ArrayList<AssociationGame.TipAnswer>) fasesAssociacao.get(i).getTipAnswers();
            fasesEmbaralhadas=new ArrayList();
            ordemRespostas=new ArrayList();
            while(ordemRespostas.size()<5){
                int j=(int) ((Math.random()*5));
                if(!ordemRespostas.contains(j)){
                    ordemRespostas.add(j);
                    fasesEmbaralhadas.add(fasesOriginal.get(j));
                }
            }
            return fasesAssociacao.get(i);
        }
        return null;
    }
    
    public int getPontuacaoTotal() {
        return pontuacaoTotal;
    }

    public void setPontuacaoTotal(int pontuacaoTotal) {
        this.pontuacaoTotal += pontuacaoTotal;
    }
    
    
    
    //chamar para verificar se completou o jogo
    public boolean completouAssociacao() {
        //TODO - enviar pontuação para o banco!
        if(getPontuacaoTotal()>=100) 
            return true;
        return false;
    }
}
