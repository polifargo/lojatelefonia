package br.com.lojatelefonia.db.utils;

import br.com.lojatelefonia.constants.MainConstant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtils {

    public static Connection getConnection() {
        //Conexão para abertura e fechamento
        Connection connection = null;
        try {
            //Só tenta abrir uma conexão se não existir ou estiver fechada            
            //Endereço de conexão com o banco de dados
            String dbURL = MainConstant.DB_ADDRESS;
            //Propriedades para armazenamento de usuário e senha
            Properties properties = new Properties();
            properties.put("user", MainConstant.DB_USER);
            properties.put("password", MainConstant.DB_PASS);
            //Realiza a conexão com o banco
            connection = DriverManager.getConnection(dbURL, properties);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        //Retorna a conexão
        return connection;
    }
}
