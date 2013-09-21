package jogoanatomia.entidades;

import java.util.ArrayList;

public class Conteudo {
    
    private String conteudo;
    
    private int idOrgao;
    
    private String urlVideo;
    
    

    public String getUrlVideo() {
        return urlVideo;
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

    public Conteudo(int idEstudos, String conteudo, int nivel,  int idOrgao) {
        this.conteudo = conteudo;
        this.idOrgao = idOrgao;
    }

}
