/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogoanatomia.entidades.actor;

import jogoanatomia.entidades.QuizGame;
import jogoanatomia.entidades.Organ;
import jogoanatomia.entidades.User;
import jogoanatomia.services.GameService;

/**
 *
 * @author Jessica
 */
public class QuizActor extends StageGameActor<QuizGame>{
    
        
     public QuizActor(GameService service, User user, Organ organ) {
        super(service, user, organ);
    }
    
    public String naoCabeLable(String original) {
        String nova = "<html>";
        int i = 70;
        int j = 0;
        while (i < original.length()) {
            if (original.charAt(i) != ' ') {
                i++;
            } else {
                nova = nova + original.substring(j, i) + "<br>";
                j = i + 1;
                i = i + 70;
            }
        }
        nova = nova + original.substring(j, original.length()) + "</html>";
        return nova;
    }

    @Override
    void afterSelectNextStage(QuizGame stage) {
        // Não sei o que fazer aqui;
    }

    @Override
    Class<QuizGame> getGameType() {
        return QuizGame.class;
    }
         
}
