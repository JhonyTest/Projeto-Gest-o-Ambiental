/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Exceptions.FiscalException;
import Factory.Database;
import Factory.Persistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Empresa;

public class EmpresaDAO {

    EntityManager entityManager;

    Query qry;
    String sql;

    public EmpresaDAO() {
        entityManager = Database.getInstance().getEntityManager();
    }

    public void save(Empresa empresa) {
        this.entityManager.getTransaction().begin();
        if (empresa != null && empresa.getId() > 0) {
            this.entityManager.merge(empresa);
        } else {
            this.entityManager.persist(empresa);
        }
        this.entityManager.getTransaction().commit();
    }

    public void delete(Empresa empresa) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(empresa);
        this.entityManager.getTransaction().commit();
    }

    public Empresa find(int id) {
        //Está é um HQL (Hibernate Query Language)
        sql = " SELECT e "
                + " FROM Empresa e "
                + " WHERE id = :id ";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("id", id);

        List lst = qry.getResultList();
        if (lst.isEmpty()) {
            return null;
        } else {
            return (Empresa) lst.get(0);
        }
    }

    public List<Empresa> findAll() {
        //Está é um HQL (Hibernate Query Language)
        sql = " SELECT e "
                + " FROM Empresa e ";

        qry = this.entityManager.createQuery(sql);

        List lst = qry.getResultList();
        return (List<Empresa>) lst;
    }

    public Empresa findByCnpj(String cnpj) {
        //Está é um HQL (Hibernate Query Language)
        sql = " SELECT e "
                + " FROM Empresa e "
                + " WHERE cnpj like :cnpj ";
        qry = this.entityManager.createQuery(sql);
        qry.setParameter("cnpj", cnpj);

        List lst = qry.getResultList();

        if (lst.isEmpty()) {
            return null;
        } else {
            return (Empresa) lst.get(0);
        }
    }

    public void update(Empresa empresa) {
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(empresa);
        this.entityManager.getTransaction().commit();
    }
}
