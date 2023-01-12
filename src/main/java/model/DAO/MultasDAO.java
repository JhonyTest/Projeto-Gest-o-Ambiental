
package model.DAO;

import Factory.Database;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Multas;

public class MultasDAO implements IDao{
    
    EntityManager entityManager;
    EntityManagerFactory factory;
    Query qry;
    String sql;

    public MultasDAO() {
        this.factory = Persistence.createEntityManagerFactory("gestao");
        this.entityManager = factory.createEntityManager();
    }

    public void save(Object obj) {
        Multas multas = (Multas) obj;
        this.entityManager.getTransaction().begin();
        if (multas != null && multas.getId() > 0) {
            this.entityManager.merge(multas);
        } else {
            this.entityManager.persist(multas);
        }
        this.entityManager.getTransaction().commit();
    }

    public void delete(Object obj) {
        Multas multas = (Multas) obj;
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(multas);
        this.entityManager.getTransaction().commit();
    }

    public void update(Object obj) {
        Multas multas = (Multas) obj;
        this.entityManager.getTransaction().begin();
        if (multas != null && multas.getId() > 0) {
            this.entityManager.merge(multas);
        } else {
            this.entityManager.persist(multas);
        }
        this.entityManager.getTransaction().commit();
    }

    public Object find(int id) {
        sql = " SELECT m "
                + " FROM Multas m "
                + " WHERE id = :id ";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("id", id);

        List lst = qry.getResultList();
        if (lst.isEmpty()) {
            return null;
        } else {
            return (Multas) lst.get(0);
        }
    }

    public List<Multas> findAll() {
        //Está é um HQL (Hibernate Query Language)
        sql = " SELECT m "
                + " FROM Multas m ";

        qry = this.entityManager.createQuery(sql);

        List lst = qry.getResultList();
        return (List<Multas>) lst;
    }

    public Multas findByCnpj(String cnpj) {
        //Está é um HQL (Hibernate Query Language)
        sql = " SELECT m "
                + " FROM Multas m "
                + " WHERE cnpj like :cnpj ";
        qry = this.entityManager.createQuery(sql);
        qry.setParameter("cnpj", cnpj);

        List lst = qry.getResultList();

        if (lst.isEmpty()) {
            return null;
        } else {
            return (Multas) lst.get(0);
        }
    }
}

