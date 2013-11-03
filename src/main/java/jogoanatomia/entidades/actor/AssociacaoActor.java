package jogoanatomia.entidades.actor;

import jogoanatomia.entidades.AssociationGame;
import jogoanatomia.entidades.Organ;
import jogoanatomia.entidades.User;
import jogoanatomia.services.GameService;

import java.util.ArrayList;

public class AssociacaoActor extends StageGameActor<AssociationGame> {
    public ArrayList<AssociationGame.TipAnswer> fasesOriginal;
    public ArrayList<AssociationGame.TipAnswer> fasesEmbaralhadas;
    public ArrayList<Integer> ordemRespostas;

    public AssociacaoActor(GameService service, User user, Organ organ) {
        super(service, user, organ);
    }

    @Override
    void afterSelectNextStage(AssociationGame stage) {
        fasesOriginal = (ArrayList<AssociationGame.TipAnswer>) stage.getTipAnswers();
        fasesEmbaralhadas=new ArrayList();
        ordemRespostas=new ArrayList();
        while(ordemRespostas.size()<5){
            int j=(int) ((Math.random()*5));
            if(!ordemRespostas.contains(j)){
                ordemRespostas.add(j);
                fasesEmbaralhadas.add(fasesOriginal.get(j));
            }
        }
    }

    @Override
    Class<AssociationGame> getGameType() {
        return AssociationGame.class;
    }
}
