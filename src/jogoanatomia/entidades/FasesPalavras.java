package jogoanatomia.entidades;

import java.util.ArrayList;

public class FasesPalavras {
    private int id;
    private int nivel;
    private String palavra;
    private int idOrgao;
    public static OperacoesJSON op=new OperacoesJSON();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public int getIdOrgao() {
        return idOrgao;
    }

    public void setIdOrgao(int idOrgao) {
        this.idOrgao = idOrgao;
    }

    public FasesPalavras(int id, int nivel, String palavra, int idOrgao) {
        this.id = id;
        this.nivel = nivel;
        this.palavra = palavra;
        this.idOrgao = idOrgao;
    }
    
    public static ArrayList<FasesPalavras> getTodas(){
        return op.getTodasFasesPalavras();
    }
    
    public static ArrayList<FasesPalavras> getPorIdOrgao(int idorgao){
        return op.getFasesPalavrasPorIdOrgao(idorgao);
    }
}
