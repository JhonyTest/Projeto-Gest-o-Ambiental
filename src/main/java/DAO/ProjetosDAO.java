/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Factory.Database;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Projetos;

/**
 *
 * @author Joao Pedro
 */
public class ProjetosDAO implements IDao{
    
    EntityManager entityManager;
    EntityManagerFactory factory;
    Query qry;
    String sql;

    public ProjetosDAO() {
        this.factory = Persistence.createEntityManagerFactory("gestao");
        this.entityManager = factory.createEntityManager();
    }

    public void save(Object obj) {
        Projetos projetos = (Projetos) obj;
        this.entityManager.getTransaction().begin();
        if (projetos != null && projetos.getId() > 0) {
            this.entityManager.merge(projetos);
        } else {
            this.entityManager.persist(projetos);
        }
        this.entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Object obj) {
        Projetos projetos = (Projetos) obj;
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(projetos);
        this.entityManager.getTransaction().commit();
    }
    
    public Object find(int id) {
        sql = " SELECT p "
                + " FROM Projetos p "
                + " WHERE id = :id ";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("id", id);

        List lst = qry.getResultList();
        if (lst.isEmpty()) {
            return null;
        } else {
            return (Projetos) lst.get(0);
        }
    }

    public void update(Object obj) {
        Projetos projetos = (Projetos) obj;
        this.entityManager.getTransaction().begin();
        if (projetos != null && projetos.getId() > 0) {
            this.entityManager.merge(projetos);
        } else {
            this.entityManager.persist(projetos);
        }
        this.entityManager.getTransaction().commit();
    }

    public Projetos findByNome(String nome) {
        //Está é um HQL (Hibernate Query Language)
        sql = " SELECT p "
                + " FROM Projetos p "
                + " WHERE nome = :nome ";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("nome", nome);

        List lst = qry.getResultList();
        if (lst.isEmpty()) {
            return null;
        } else {
            return (Projetos) lst.get(0);
        }
    }

    public List<Projetos> findAll() {
        //Está é um HQL (Hibernate Query Language)
        sql = " SELECT p "
                + " FROM Projetos p ";

        qry = this.entityManager.createQuery(sql);

        List lst = qry.getResultList();
        return (List<Projetos>) lst;
    
    }
}
