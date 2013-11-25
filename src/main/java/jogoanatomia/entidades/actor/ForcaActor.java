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
    String palavraOriginal="";
    String palavraForca="";
    public ArrayList<String> listaLetrasErradas;
    public ArrayList<String> listaLetrasCertas;

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
        listaLetrasCertas = new ArrayList<String>();
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
        this.palavraOriginal = palavraForca.toUpperCase();
        this.palavraForca = replaceCaracteres(this.palavraOriginal);
    }
    
    public String replaceCaracteres(String original) {
        String resultado="";
        for(int i=0; i<original.length();i++) {
            char letra = original.charAt(i);
            switch(letra) {
                case 'Á':
                    letra = 'A';
                    break;
                case 'À':
                    letra = 'A';
                    break;
                case 'Ã':
                    letra = 'A';
                    break;
                case 'É':
                    letra = 'E';
                    break;
                case 'Í':
                    letra = 'I';
                    break;
                case 'Ó':
                    letra = 'O';
                    break;
                case 'Õ':
                    letra = 'O';
                    break;
                case 'Ú':
                    letra = 'U';
                    break;
                case 'Ü':
                    letra = 'U';
                    break;
                case 'Ç':
                    letra = 'C';
                    break;
            }
            resultado = resultado + letra;
        }
        return resultado;
    }
}
