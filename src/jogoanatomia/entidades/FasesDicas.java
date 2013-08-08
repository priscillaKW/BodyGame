package jogoanatomia.entidades;

import java.util.ArrayList;

public class FasesDicas {
    private int id;
    private int nivel;
    private String dica;
    private String resposta;
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

    public String getDica() {
        return dica;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public int getIdOrgao() {
        return idOrgao;
    }

    public void setIdOrgao(int idOrgao) {
        this.idOrgao = idOrgao;
    }

    public FasesDicas(int id, int nivel, String dica, String resposta, int idOrgao) {
        this.id = id;
        this.nivel = nivel;
        this.dica = dica;
        this.resposta = resposta;
        this.idOrgao = idOrgao;
    }
 
    public static ArrayList<FasesDicas> getTodas(){
        return op.getTodasFasesDicas();
    }
    
    public static ArrayList<FasesDicas> getPorIdOrgao(int idO){
        return op.getFasesDicasPorIdOrgao(idO);
    }
}
