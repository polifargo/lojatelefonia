/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojatelefonia.services;

import br.com.lojatelefonia.dao.DaoCliente;
import br.com.lojatelefonia.exceptions.ClienteException;
import br.com.lojatelefonia.exceptions.DataSourceException;

/**
 *
 * @author Rafael Ferreira
 */
public class ServiceCliente {

    //Insere um cliente na fonte de dados
    public static void cadastrarCliente(String nomeCliente, String nascCliente, String telefoneCliente, String cpfCliente)
            throws ClienteException, DataSourceException {
        //Realização de validações de negócio
        if (nomeCliente == null || "".equals(nomeCliente)) {
            throw new ClienteException("É necessário informar um nome de cliente");
        }
        if (nascCliente == null || "".equals(nascCliente)) {
            throw new ClienteException("É necessário informar a data de nascimento");
        }
        if (telefoneCliente == null || "".equals(telefoneCliente)) {
            throw new ClienteException("É necessário informar um telefone");
        }
        if (cpfCliente == null || "".equals(cpfCliente)) {
            throw new ClienteException("É necessário informar o cpf");
        }

        try {
            //Realiza a chamada de inserção na fonte de dados
            DaoCliente.inserir(nomeCliente, nascCliente, telefoneCliente, cpfCliente);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Atualiza um cliente na fonte de dados
    public static void atualizarCliente(Integer idCliente, String nomeCliente, String nascCliente, String telefoneCliente, String cpfCliente)
            throws ClienteException, DataSourceException {
        //Realização de validações de negócio
        if (nomeCliente == null || "".equals(nomeCliente)) {
            throw new ClienteException("É necessário informar um nome de cliente");
        }
        if (nascCliente == null || "".equals(nascCliente)) {
            throw new ClienteException("É necessário informar a data de nascimento");
        }
        if (telefoneCliente == null || "".equals(telefoneCliente)) {
            throw new ClienteException("É necessário informar um telefone");
        }
        if (cpfCliente == null || "".equals(cpfCliente)) {
            throw new ClienteException("É necessário informar o cpf");
        }

        try {
            //Realiza a chamada de atualização na fonte de dados
            DaoCliente.atualizar(idCliente, nomeCliente, nascCliente, telefoneCliente, cpfCliente);
            return;
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Excluir cliente
    public static void excliurCliente(Integer idCliente, Integer option)
            throws ClienteException, DataSourceException {
        if (idCliente != null && option == 0) {
            try {
                //Realiza a exclusão do cliente por id
                DaoCliente.excluir(idCliente);
                return;
            } catch (Exception e) {
                //Imprime qualquer erro técnico no console e devolve uma exceção e uma mensagem amigável a camada de visão
                e.printStackTrace();
                throw new DataSourceException("Erro na fonte de dados", e);
            }
        }
    }
}
