package jogoanatomia.entidades;

import java.util.ArrayList;

public class FasesPerguntas {
    private int id;
    private int nivel;
    private String pergunta;
    private String letraCerta;
    private String respA;
    private String respB;
    private String respC;
    private String respD;
    private int idOrgao;

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

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getLetraCerta() {
        return letraCerta;
    }

    public void setLetraCerta(String letraCerta) {
        this.letraCerta = letraCerta;
    }

    public String getRespA() {
        return respA;
    }

    public void setRespA(String respA) {
        this.respA = respA;
    }

    public String getRespB() {
        return respB;
    }

    public void setRespB(String respB) {
        this.respB = respB;
    }

    public String getRespC() {
        return respC;
    }

    public void setRespC(String respC) {
        this.respC = respC;
    }

    public String getRespD() {
        return respD;
    }

    public void setRespD(String respD) {
        this.respD = respD;
    }

    public int getIdOrgao() {
        return idOrgao;
    }

    public void setIdOrgao(int idOrgao) {
        this.idOrgao = idOrgao;
    }

    public FasesPerguntas(int id, int nivel, String pergunta, String letraCerta, String respA, String respB, String respC, String respD, int idOrgao) {
        this.id = id;
        this.nivel = nivel;
        this.pergunta = pergunta;
        this.letraCerta = letraCerta;
        this.respA = respA;
        this.respB = respB;
        this.respC = respC;
        this.respD = respD;
        this.idOrgao = idOrgao;
    }
}
