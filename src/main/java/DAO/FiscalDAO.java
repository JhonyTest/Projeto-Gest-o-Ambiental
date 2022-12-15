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
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Fiscal;

public class FiscalDAO {

    EntityManager entityManager;

    Query qry;
    String sql;

    public FiscalDAO() {
        entityManager = Database.getInstance().getEntityManager();
    }

    public void save(Fiscal fiscal) {
        this.entityManager.getTransaction().begin();
        if (fiscal != null && fiscal.getId() > 0) {
            this.entityManager.merge(fiscal);
        } else {
            this.entityManager.persist(fiscal);
        }
        this.entityManager.getTransaction().commit();
    }

    public void delete(Fiscal fiscal) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(fiscal);
        this.entityManager.getTransaction().commit();
    }
    
        public void update(Fiscal fiscal) {
       this.entityManager.getTransaction().begin();
        if (fiscal != null && fiscal.getId() > 0) {
            this.entityManager.merge(fiscal);
        } else {
            this.entityManager.persist(fiscal);
        }
        this.entityManager.getTransaction().commit();
    }

       public Fiscal login(String pass){
           
         
        return null;
           
         
       }
    

    public Fiscal find(int id) {
        //Está é um HQL (Hibernate Query Language)
        sql = " SELECT f "
                + " FROM Fiscal f "
                + " WHERE id = :id ";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("id", id);

        List lst = qry.getResultList();
        if (lst.isEmpty()) {
            return null;
        } else {
            return (Fiscal) lst.get(0);
        }
    }

    public List<Fiscal> findAll() {
        //Está é um HQL (Hibernate Query Language)
        sql = " SELECT f "
                + " FROM Fiscal f ";

        qry = this.entityManager.createQuery(sql);

        List lst = qry.getResultList();
        return (List<Fiscal>) lst;
    }

    public Fiscal findByCpf(String cpf) {
        //Está é um HQL (Hibernate Query Language)
        sql = " SELECT f "
                + " FROM Fiscal f "
                + " WHERE cpf like :cpf ";
        qry = this.entityManager.createQuery(sql);
        qry.setParameter("cpf", cpf);

        List lst = qry.getResultList();

        if (lst.isEmpty()) {
            return null;
        } else {
            return (Fiscal) lst.get(0);
        }
    }
    
    public boolean login(String cpf, String pass)
    {
       try{
            EntityTransaction entr=entityManager.getTransaction();
            entr.begin();

        TypedQuery<Fiscal> query = entityManager.createQuery("SELECT u FROM fiscal f WHERE f.cpf = :cpf AND f.password = :pass", Fiscal.class);        
        query.setParameter(1, cpf);
        query.setParameter(2, pass); 
        try{ 
            Fiscal f = query.getSingleResult();
            return true;
        }catch(javax.persistence.NoResultException e)
        {
            return false;
        }
        }
        finally{
        entityManager.close();
        }

    }

}