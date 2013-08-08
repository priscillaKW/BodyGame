package jogoanatomia.entidades;

import java.util.ArrayList;

public class Estudos {

    private int idEstudos;
    private int nivel;
    private String conteudo;
    private int idOrgao;
    public static OperacoesJSON op=new OperacoesJSON();

    public int getIdEstudos() {
        return idEstudos;
    }

    public void setIdEstudos(int idEstudos) {
        this.idEstudos = idEstudos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getIdOrgao() {
        return idOrgao;
    }

    public void setIdOrgao(int idOrgao) {
        this.idOrgao = idOrgao;
    }

    public Estudos(int idEstudos, String conteudo, int nivel,  int idOrgao) {
        this.idEstudos = idEstudos;
        this.nivel = nivel;
        this.conteudo = conteudo;
        this.idOrgao = idOrgao;
    }

    public static ArrayList<Estudos> getPorOrgao(int idorgao){
        return op.getEstudosPorOrgao(idorgao);
    }
}
