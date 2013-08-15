package jogoanatomia.entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {

    private static Banco unico = null;
    private static String banco = "bodygame_db";
    private static String usuario = "root";
    private static String senha = "";
    private static java.sql.Connection conexao = null;

    public static Banco getInstance() {
        if (unico == null) {
            unico = new Banco();
        }
        return unico;
    }

    public java.sql.Connection getConexao() {
        try {
            // Carregando o JDBC Driver padrão  
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            // Configurando a nossa conexão com um banco de dados//  
            String serverName = "localhost";    //caminho do servidor do BD  
            String url = "jdbc:mysql://" + serverName + "/" + banco;
            Connection connection = DriverManager.getConnection(url, usuario, senha);
            return connection;
        } catch (ClassNotFoundException e) {  //Driver não encontrado  
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            //Não conseguindo se conectar ao banco  
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }
}
