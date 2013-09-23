package jogoanatomia.entidades;

import java.util.ArrayList;

public class Orgao {
    
    private int idOrgao;
    
    private String nome;
    
    private String malha;    
    
    // TODO retirar json
    private static OperacoesJSON op=new OperacoesJSON();
    
    private int status;

    
    /**
     * 
     * @return 1 se finalizado, 0 caso contrário;
     */
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Orgao(){
    }
    
    
    public int getIdOrgao() {
        return idOrgao;
    }

    public void setIdOrgao(int idOrgao) {
        this.idOrgao = idOrgao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMalha() {
        return malha;
    }

    public void setMalha(String malha) {
        this.malha = malha;
    }

    public Orgao(int idOrgao, String nome, String malha) {
        this.idOrgao = idOrgao;
        this.nome = nome;
        this.malha = malha;
    }
    
    
    //TODO Mover para método DAO
    public static ArrayList<Orgao> getTodos(){
        return op.getTodosOrgaos();
    }
    
    public static ArrayList<Orgao> getOrgaoPorId(int id){
        return op.getOrgaoPorId(id);
    }
}