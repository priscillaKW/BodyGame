/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogoanatomia.entidades.dao;

import java.util.ArrayList;
import jogoanatomia.entidades.Orgao;

/**
 *
 * @author Jessica
 */
public class OrgaoDAO {
    
    public ArrayList retornaTodos(){
        // TODO arrumar método DAO;
        ArrayList orgaos = new ArrayList();
        Orgao coracao = new Orgao();
        coracao.setIdOrgao(0);
        coracao.setMalha("./coracao.obj");
        coracao.setNome("Coração");
        coracao.setStatus(1);
        Orgao rim = new Orgao();
        rim.setIdOrgao(0);
        rim.setMalha("./rim.obj");
        rim.setNome("Rim");
        rim.setStatus(0);
        orgaos.add(rim);
        orgaos.add(coracao);
        return orgaos;
    }
    
}
