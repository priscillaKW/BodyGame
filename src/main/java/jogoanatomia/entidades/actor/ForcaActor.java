package jogoanatomia.entidades.actor;

import java.util.ArrayList;
import java.util.List;
import jogoanatomia.entidades.HangmanGame;
import jogoanatomia.entidades.Organ;
import jogoanatomia.entidades.User;
import jogoanatomia.services.GameService;
import jogoanatomia.services.GameServiceImpl;

/**
 *
 * @author Priscilla
 */
public class ForcaActor extends StageGameActor<HangmanGame> {

    int pontuacaoTotal=0;
    int letrasErradas=0;
    String palavraForca="";
    public ArrayList<String> listaLetrasErradas;

    public ForcaActor(GameService service, User user, Organ organ) {
        super(service, user, organ);
    }

    public String gerarMascara(){
        String retorno="";        
        for(int i=0; i<getPalavraForca().length();i++){
            if(getPalavraForca().charAt(i)==' ') {
                retorno=retorno+"-";
            }
            else {
                retorno=retorno+"_";
            }
        }
        return retorno;
    }

    public String quantLetras(){
        String temp=palavraForca.replaceAll(" ", "");
        return "Essa palavra tem " + temp.length() + " letras.";
    }

    @Override
    void afterSelectNextStage(HangmanGame stage) {
        setLetrasErradas(0);
        setPalavraForca(stage.getAnswer());
        listaLetrasErradas = new ArrayList<String>();
    }

    @Override
    Class<HangmanGame> getGameType() {
        return HangmanGame.class;
    }

    public int getLetrasErradas() {
        return letrasErradas;
    }

    public void setLetrasErradas(int letrasErradas) {
        this.letrasErradas = letrasErradas;
    }

    public String getPalavraForca() {
        return palavraForca;
    }

    public void setPalavraForca(String palavraForca) {
        this.palavraForca = palavraForca.toUpperCase();
    }
}
