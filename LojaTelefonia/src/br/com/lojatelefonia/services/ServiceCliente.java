/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojatelefonia.services;
import br.com.lojatelefonia.dao.DaoCliente;
import br.com.lojatelefonia.exceptions.ClienteException;
import br.com.lojatelefonia.exceptions.DataSourceException;
import br.com.lojatelefonia.models.Cliente;

/**
 *
 * @author Rafael Ferreira
 */
public class ServiceCliente {
    //Insere um cliente na fonte de dados
    public static void cadastrarCliente(Cliente cliente)
            throws ClienteException, DataSourceException {
        //Realização de validações de negócio
        if (cliente.getNome() == null || "".equals(cliente.getNome())) {
            throw new ClienteException("É necessário informar um nome de cliente");
        }
        if (cliente.getNasc() == null || "".equals(cliente.getNasc())) {
            throw new ClienteException("É necessário informar a data de nascimento");
        }
        if (cliente.getTelefone() == null || "".equals(cliente.getTelefone())){
            throw new ClienteException("É necessário informar um telefone");
        }
        if (cliente.getCpf() == null || "".equals(cliente.getCpf())){
            throw new ClienteException("É necessário informar o cpf");
        }

        try {
            //Realiza a chamada de inserção na fonte de dados
            DaoCliente.inserir(cliente);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Atualiza um cliente na fonte de dados
    public static void atualizarCliente(Cliente cliente)
            throws ClienteException, DataSourceException {
        //Realização de validações de negócio
        if (cliente.getNome() == null || "".equals(cliente.getNome())) {
            throw new ClienteException("É necessário informar um nome de cliente");
        }
        if (cliente.getNasc() == null || "".equals(cliente.getNasc())) {
            throw new ClienteException("É necessário informar a data de nascimento");
        }
        if (cliente.getTelefone() == null || "".equals(cliente.getTelefone())) {
            throw new ClienteException("É necessário informar o telefone");
        }
        if (cliente.getCpf() == null || "".equals(cliente.getCpf())) {
            throw new ClienteException("É necessário informar o cpf");
        }

        try {
            //Realiza a chamada de atualização na fonte de dados
            DaoCliente.atualizar(cliente);
            return;
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
}
