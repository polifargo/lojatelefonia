/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojatelefonia.dao;

import br.com.lojatelefonia.db.utils.ConnectionUtils;
import br.com.lojatelefonia.models.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rafael Ferreira
 */
public class DaoProduto {

    public static void inserir(String nomeProduto, String descProduto, String marcaProduto,
            String numProduto, String fabriProduto, Integer qtdProduto, Double valorProduto)
            throws SQLException, Exception {
        //Monta a string de inserção de um produto no BD, utilizando os dados do produtos passados como parâmetro
        String sql = "INSERT INTO produtos (nome, descricao, marca, numproduto, fabricacao, qtd, valor) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, nomeProduto);
            preparedStatement.setString(2, descProduto);
            preparedStatement.setString(3, marcaProduto);
            preparedStatement.setString(4, numProduto);
            preparedStatement.setString(5, fabriProduto);
            preparedStatement.setInt(6, qtdProduto);
            preparedStatement.setDouble(7, valorProduto);

            //Executa o comando no banco de dados
            preparedStatement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static void atualizar(Integer idProduto, String nomeProduto, String descProduto, String marcaProduto,
            String numProduto, String fabriProduto, Integer qtdProduto, Double valorProduto)
            throws SQLException, Exception {
        //Monta a string de atualização do produto no BD, utilizando prepared statement
        String sql = "UPDATE produtos SET nome=?, descricao=?, marca=?, numproduto=?, fabricacao=?, qtd=?, valor=? "
                + "WHERE id=?";
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setInt(1, idProduto);
            preparedStatement.setString(2, nomeProduto);
            preparedStatement.setString(3, descProduto);
            preparedStatement.setString(4, marcaProduto);
            preparedStatement.setString(5, numProduto);
            preparedStatement.setString(6, fabriProduto);
            preparedStatement.setInt(7, qtdProduto);
            preparedStatement.setDouble(8, valorProduto);

            //Executa o comando no banco de dados
            preparedStatement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static void excluir(Integer idProduto) throws SQLException, Exception {
        //Monta a string de atualização do produto no BD, utilizando prepared statement
        String sql = "DELETE FROM produtos WHERE id = " + idProduto;
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Executa o comando no banco de dados
            preparedStatement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static ArrayList<Produto> getListaProdutos() {
        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
        Connection connection = null;
        connection = ConnectionUtils.getConnection();

        String query = "SELECT * FROM produtos";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Produto produto;
            while (rs.next()) {
                produto = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"),
                        rs.getString("marca"), rs.getString("numproduto"), rs.getString("fabricacao"),
                        rs.getInt("qtd"), rs.getDouble("valor"));
                listaProdutos.add(produto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProdutos;
    }
}
