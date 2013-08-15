package jogoanatomia.entidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OperacoesJSON {

    private URL feedUrl = null;

    public void setURL(String url) {
        try {
            feedUrl = new URL(url);
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        }
    }

    public URL getURL() {
        return feedUrl;
    }

    public InputStream getInputStream() {
        try {
            return feedUrl.openConnection().getInputStream();
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    public static String convertStreamToString(final InputStream input) {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        final StringBuilder sBuf = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sBuf.append(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return sBuf.toString();
    }
    
    public ArrayList<Orgao> getTodosOrgaos() { 
        //String url="http://bodygame.orgfree.com/verificaLogin.php?login="+login+"&senha="+senha+"blabla";
        String url="http://bodygame.orgfree.com/obtemOrgaos.php";
        setURL(url);
        // Converte em string
        final String result = convertStreamToString(this.getInputStream());
        ArrayList<Orgao> resultado=new ArrayList<Orgao>();
        try {
            // Tranforma a string em objeto JSON
            final JSONObject json = new JSONObject(result);
            final JSONArray orgaos = json.getJSONArray("orgaos");
            // Obtem os campos do objeto
            for(int i=0;i<orgaos.length();i++){
                JSONObject org=orgaos.getJSONObject(i);
                String id=org.getString("idorgao");
                String nome=org.getString("nome");
                String malha=org.getString("malha");
                Orgao orgao=new Orgao(Integer.parseInt(id), nome, malha);
                resultado.add(orgao);
            }
            return resultado;
        } catch (JSONException e) {
            System.out.println(e);
            return null;
        }
    }
    
    public ArrayList<Orgao> getOrgaoPorId(int id) { 
        //String url="http://bodygame.orgfree.com/verificaLogin.php?login="+login+"&senha="+senha+"blabla";
        String url="http://bodygame.orgfree.com/obtemOrgaoPorId.php?idorgao="+id;
        setURL(url);
        // Converte em string
        final String result = convertStreamToString(this.getInputStream());
        ArrayList<Orgao> resultado = new ArrayList<Orgao>();
        try {
            // Tranforma a string em objeto JSON
            final JSONObject json = new JSONObject(result);
            final JSONArray orgaos = json.getJSONArray("orgaos");
            // Obtem os campos do objeto
            for(int i=0;i<orgaos.length();i++){
                JSONObject org=orgaos.getJSONObject(i);
                String idorgao=org.getString("idorgao");
                String nome=org.getString("nome");
                String malha=org.getString("malha");
                Orgao orgao=new Orgao(Integer.parseInt(idorgao), nome, malha);
                resultado.add(orgao);
            }
            return resultado;
        } catch (JSONException e) {
            System.out.println(e);
            return null;
        }
    }
    
    public ArrayList<Estudos> getEstudosPorOrgao(int idorgao) { 
        String url="http://bodygame.orgfree.com/obtemEstudos.php?idorgao="+idorgao;
        setURL(url);
        // Converte em string
        final String result = convertStreamToString(this.getInputStream());
        ArrayList<Estudos> resultado=new ArrayList<Estudos>();
        try {
            // Tranforma a string em objeto JSON
            final JSONObject json = new JSONObject(result);
            final JSONArray estudos = json.getJSONArray("estudos");
            // Obtem os campos do objeto
            for(int i=0;i<estudos.length();i++){
                JSONObject org=estudos.getJSONObject(i);
                String id=org.getString("idestudos");
                String conteudo=org.getString("conteudo");
                String nivel=org.getString("nivel");
                String ido=org.getString("idorgao");
                Estudos estudo=new Estudos(Integer.parseInt(id), conteudo, Integer.parseInt(nivel), Integer.parseInt(ido));
                resultado.add(estudo);
            }
            return resultado;
        } catch (JSONException e) {
            System.out.println(e);
            return null;
        }
    }
    
    public ArrayList<Ranking> getRankingOrdenado(int idjogo) { 
        String url="http://bodygame.orgfree.com/obtemRanking.php?idjogo="+idjogo;
        setURL(url);
        // Converte em string
        final String result = convertStreamToString(this.getInputStream());
        ArrayList<Ranking> resultado=new ArrayList<Ranking>();
        try {
            // Tranforma a string em objeto JSON
            final JSONObject json = new JSONObject(result);
            final JSONArray ranking = json.getJSONArray("ranking");
            // Obtem os campos do objeto
            for(int i=0;i<ranking.length();i++){
                JSONObject org=ranking.getJSONObject(i);
                String id=org.getString("idranking");
                String nome=org.getString("nome");
                String pontos=org.getString("pontos");
                String idj=org.getString("idjogo");
                Ranking rank=new Ranking(Integer.parseInt(id), nome, Integer.parseInt(pontos), Integer.parseInt(idj));
                resultado.add(rank);
            }
            return resultado;
        } catch (JSONException e) {
            System.out.println(e);
            return null;
        }
    }
    
    public ArrayList<FasesDicas> getTodasFasesDicas() {         
        String url="http://bodygame.orgfree.com/obtemFasesDicas.php";
        setURL(url);
        // Converte em string
        final String result = convertStreamToString(this.getInputStream());
        ArrayList<FasesDicas> resultado=new ArrayList<FasesDicas>();
        try {
            // Tranforma a string em objeto JSON
            final JSONObject json = new JSONObject(result);
            final JSONArray fasesDicas = json.getJSONArray("fasesdicas");
            // Obtem os campos do objeto
            for(int i=0;i<fasesDicas.length();i++){
                JSONObject fase=fasesDicas.getJSONObject(i);
                String id=fase.getString("id");
                String nivel=fase.getString("nivel");
                String dica=fase.getString("dica");
                String resposta=fase.getString("resposta");
                String idorgao=fase.getString("idorgao");
                FasesDicas fases=new FasesDicas(Integer.parseInt(id), Integer.parseInt(nivel), dica, resposta, Integer.parseInt(idorgao));
                resultado.add(fases);
            }
            return resultado;
        } catch (JSONException e) {
            System.out.println(e);
            return null;
        }
    }
    
    public ArrayList<FasesDicas> getFasesDicasPorIdOrgao(int idO) {         
        String url="http://bodygame.orgfree.com/obtemFasesDicasPorId.php?idorgao="+idO;
        setURL(url);
        // Converte em string
        final String result = convertStreamToString(this.getInputStream());
        ArrayList<FasesDicas> resultado=new ArrayList<FasesDicas>();
        try {
            // Tranforma a string em objeto JSON
            final JSONObject json = new JSONObject(result);
            final JSONArray fasesDicas = json.getJSONArray("fasesdicas");
            // Obtem os campos do objeto
            for(int i=0;i<fasesDicas.length();i++){
                JSONObject fase=fasesDicas.getJSONObject(i);
                String id=fase.getString("id");
                String nivel=fase.getString("nivel");
                String dica=fase.getString("dica");
                String resposta=fase.getString("resposta");
                String idorgao=fase.getString("idorgao");
                FasesDicas fases=new FasesDicas(Integer.parseInt(id), Integer.parseInt(nivel), dica, resposta, Integer.parseInt(idorgao));
                resultado.add(fases);
            }
            return resultado;
        } catch (JSONException e) {
            System.out.println(e);
            return null;
        }
    }
    
    public ArrayList<FasesPalavras> getTodasFasesPalavras() {         
        String url="http://bodygame.orgfree.com/obtemFasesPalavras.php";
        setURL(url);
        // Converte em string
        final String result = convertStreamToString(this.getInputStream());
        ArrayList<FasesPalavras> resultado=new ArrayList<FasesPalavras>();
        try {
            // Tranforma a string em objeto JSON
            final JSONObject json = new JSONObject(result);
            final JSONArray fasesPalavras = json.getJSONArray("fasespalavras");
            // Obtem os campos do objeto
            for(int i=0;i<fasesPalavras.length();i++){
                JSONObject fase=fasesPalavras.getJSONObject(i);
                String id=fase.getString("id");
                String nivel=fase.getString("nivel");
                String palavra=fase.getString("palavra");
                String idorgao=fase.getString("idorgao");
                FasesPalavras fases=new FasesPalavras(Integer.parseInt(id), Integer.parseInt(nivel), palavra, Integer.parseInt(idorgao));
                resultado.add(fases);
            }
            return resultado;
        } catch (JSONException e) {
            System.out.println(e);
            return null;
        }
    }
    
    public ArrayList<FasesPalavras> getFasesPalavrasPorIdOrgao(int idO) {         
        String url="http://bodygame.orgfree.com/obtemFasesPalavrasPorId.php?idorgao="+idO;
        setURL(url);
        // Converte em string
        final String result = convertStreamToString(this.getInputStream());
        ArrayList<FasesPalavras> resultado=new ArrayList<FasesPalavras>();
        try {
            // Tranforma a string em objeto JSON
            final JSONObject json = new JSONObject(result);
            final JSONArray fasesPalavras = json.getJSONArray("fasespalavras");
            // Obtem os campos do objeto
            for(int i=0;i<fasesPalavras.length();i++){
                JSONObject fase=fasesPalavras.getJSONObject(i);
                String id=fase.getString("id");
                String nivel=fase.getString("nivel");
                String palavra=fase.getString("palavra");
                String idorgao=fase.getString("idorgao");
                FasesPalavras fases=new FasesPalavras(Integer.parseInt(id), Integer.parseInt(nivel), palavra, Integer.parseInt(idorgao));
                resultado.add(fases);
            }
            return resultado;
        } catch (JSONException e) {
            System.out.println(e);
            return null;
        }
    }
    
    public ArrayList<FasesPerguntas> getTodasFasesPerguntas() {         
        String url="http://bodygame.orgfree.com/obtemFasesPerguntas.php";
        setURL(url);
        // Converte em string
        final String result = convertStreamToString(this.getInputStream());
        ArrayList<FasesPerguntas> resultado=new ArrayList<FasesPerguntas>();
        try {
            // Tranforma a string em objeto JSON
            final JSONObject json = new JSONObject(result);
            final JSONArray fasesPerguntas = json.getJSONArray("fasesperguntas");
            // Obtem os campos do objeto
            for(int i=0;i<fasesPerguntas.length();i++){
                JSONObject fase=fasesPerguntas.getJSONObject(i);
                String id=fase.getString("id");
                String nivel=fase.getString("nivel");
                String pergunta=fase.getString("pergunta");
                String letracerta=fase.getString("letracerta");
                String respa=fase.getString("respa");
                String respb=fase.getString("respb");
                String respc=fase.getString("respc");
                String respd=fase.getString("respd");
                String idorgao=fase.getString("idorgao");
                
                FasesPerguntas fases=new FasesPerguntas(Integer.parseInt(id), Integer.parseInt(nivel), pergunta, letracerta, respa, respb, respc, respd, Integer.parseInt(idorgao));
                resultado.add(fases);
            }
            return resultado;
        } catch (JSONException e) {
            System.out.println(e);
            return null;
        }
    }
}