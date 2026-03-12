package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    //Metodo para retornar conexao com o banco de dados
    public static Connection getConnection() throws Exception{
        var host = "jdbc:postgresql://localhost:5432/bdprodutos";
        var user = "postgres";
        var pass = "coti";

        //retonar conexao com o banco
        return DriverManager.getConnection(host, user, pass);
    }
}
