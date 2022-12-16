/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Factory.Database;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Fiscal;

public class FiscalDAO {

    EntityManager entityManager;
    EntityManagerFactory factory;
    Query qry;
    String sql;

    public FiscalDAO() {
        entityManager = Database.getInstance().getEntityManager();
    }

    public void save(Object obj) {
        Fiscal fiscal = (Fiscal) obj;
        this.entityManager.getTransaction().begin();
        if (fiscal != null && fiscal.getId() > 0) {
            this.entityManager.merge(fiscal);
        } else {
            this.entityManager.persist(fiscal);
        }
        this.entityManager.getTransaction().commit();
    }

    public void delete(Object obj) {
        Fiscal fiscal = (Fiscal) obj;
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(fiscal);
        this.entityManager.getTransaction().commit();
    }

    public void update(Object obj) {
        Fiscal fiscal = (Fiscal) obj;
        this.entityManager.getTransaction().begin();
        if (fiscal != null && fiscal.getId() > 0) {
            this.entityManager.merge(fiscal);
        } else {
            this.entityManager.persist(fiscal);
        }
        this.entityManager.getTransaction().commit();
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

}
