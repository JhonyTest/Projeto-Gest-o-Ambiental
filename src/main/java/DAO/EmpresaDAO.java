/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Factory.Persistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Empresa;

public class EmpresaDAO implements IDao {

    protected Connection connection;
    private PreparedStatement statement;
    private List<Object> lst;

    public EmpresaDAO() {
        //this.connection = Persistencia.getInstance().getConexao();     
    }

    @Override
    public void save(Object obj) {
        Empresa empresa = (Empresa) obj;

        String sql = " INSERT INTO "
                + " empresa(nome, cnpj) "
                + " VALUES(?,?) ";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);

            //preencher cada ? com o campo adequado
            statement.setString(1, empresa.getNome());
            statement.setString(2, empresa.getCnpj() + "");

            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public Empresa findByCnpj(String cnpj) {
        for (Object obj : this.lst) {
            Empresa empresa = (Empresa) obj;
            if (empresa.getCnpj().equals(cnpj)) {
                return empresa;
            }
        }

        return null;
    }

    public void update(Object obj) {
        Empresa empresa = (Empresa) obj;

        String sql = " UPDATE empresa "
                + " SET nome=?"
                + " WHERE cnpj = ?";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);

            //preencher cada ? com o campo adequado
            statement.setString(1, empresa.getNome());

            //preenche a condição do WHERE
            statement.setString(2, empresa.getCnpj());

            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            Persistencia.closeConnection();
        }
    }

    /**
     * Procura uma empresa pelo CNPJ, que é o identificador único
     *
     * @param cnpj da empresa
     * @return Referencia para a empresa na lstEmpresa
     */
    /**
     * Recebe uma Empresa como parametro, procura a Empresa pelo Cnpj Se
     * encontrar remove ele da lstEmpresa.
     *
     * @param obj
     * @param Empresa
     * @return
     */
    @Override
    public boolean delete(Object obj) {
        Empresa empresa = (Empresa) obj;

        String sql = " DELETE FROM empresa WHERE cnpj = ? ";
        try {
            connection = Persistencia.getConnection();
            statement = connection.prepareStatement(sql);
            //preenche a condição

            statement.execute();
            statement.close();
            return true;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            Persistencia.closeConnection();
        }
    }

    @Override
    public Object find(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
