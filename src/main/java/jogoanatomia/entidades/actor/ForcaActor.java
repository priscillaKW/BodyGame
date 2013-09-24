/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogoanatomia.entidades.actor;

import java.util.ArrayList;
import java.util.List;
import jogoanatomia.entidades.HangmanGame;
import jogoanatomia.services.GameServiceImpl;

/**
 *
 * @author Priscilla
 */
public class ForcaActor {
    
    ArrayList<HangmanGame> fasesForca;
    
    int pontuacaoTotal=0;
    int letrasErradas=0;
    String palavraForca="";
    public ArrayList<String> listaLetrasErradas;
    
    public GameServiceImpl game;
    
    
    public void sorteiaFaseDicas(String idOrgao) {
        game = new GameServiceImpl();
        List<HangmanGame> todas = game.listHangmanGamesByOrganId(idOrgao);
        fasesForca = (ArrayList<HangmanGame>) todas;
    }
    
    public HangmanGame getProxFase(int i) {
        if(fasesForca.size()>i){
            setLetrasErradas(0);
            setPalavraForca(fasesForca.get(i).getAnswer());
            listaLetrasErradas=new ArrayList<String>();
            return fasesForca.get(i);
        }
        return null;
    }
    
    public int getPontuacaoTotal() {
        return pontuacaoTotal;
    }

    public void setPontuacaoTotal(int pontuacaoTotal) {
        this.pontuacaoTotal += pontuacaoTotal;
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
        gerarMascara();
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
    
    //chamar para verificar se completou o jogo
    public boolean completouForca() {
        //TODO - enviar pontuação para o banco!
        if(getPontuacaoTotal()>=10) 
            return true;
        return false;
    }
}
