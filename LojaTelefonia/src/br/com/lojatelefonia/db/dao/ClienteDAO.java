/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojatelefonia.db.dao;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author BRMA_2
 */
public class ClienteDAO {
            public static void excluir(Integer id) throws SQLException, Exception {
        //Monta a string de atualização do cliente no BD, utilizando
        //o ID do cliente passado como parâmetro para desativá-lo
        String sql = "UPDATE cliente SET "
                + "enabled=false"
                + " WHERE (cliente_id=" + id + ")";

        //Executa o comando SQL montado
        executarSQL(sql);
    }
}
