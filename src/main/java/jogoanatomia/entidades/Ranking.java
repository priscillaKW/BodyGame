package jogoanatomia.entidades;

import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Ranking {
    private int idRanking;
    private String nome;
    private int pontos;
    private int idjogo;
    private static OperacoesJSON op=new OperacoesJSON();

    public int getIdRanking() {
        return idRanking;
    }

    public void setIdRanking(int idRanking) {
        this.idRanking = idRanking;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getIdjogo() {
        return idjogo;
    }

    public void setIdjogo(int idjogo) {
        this.idjogo = idjogo;
    }

    public Ranking(int idRanking, String nome, int pontos, int idjogo) {
        this.idRanking = idRanking;
        this.nome = nome;
        this.pontos = pontos;
        this.idjogo = idjogo;
    }
    
    public static void insereRegistro(String nome, int pontos, int idJ) {
        {
            nome = nome.replace(" ", "%20");
            try {
                String url = "http://bodygame.orgfree.com/insereRanking.php?nome=" + nome + "&pontos=" + pontos + "&idjogo=" + idJ;
                op.setURL(url);
                op.convertStreamToString(op.getInputStream());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static ArrayList<Ranking> getRankingOrdenado(int idj){
        return op.getRankingOrdenado(idj);
    }
}
