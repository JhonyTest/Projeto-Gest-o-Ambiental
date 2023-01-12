
package model.DAO;

import Factory.Database;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Empresa;

public class EmpresaDAO {

    EntityManager entityManager;
    EntityManagerFactory factory;
    Query qry;
    String sql;

    public EmpresaDAO() {
        entityManager = Database.getInstance().getEntityManager();
    }

    public void save(Object obj) {
        Empresa empresa = (Empresa) obj;
        this.entityManager.getTransaction().begin();
        if (empresa != null && empresa.getId() > 0) {
            this.entityManager.merge(empresa);
        } else {
            this.entityManager.persist(empresa);
        }
        this.entityManager.getTransaction().commit();
    }

    public void delete(Object obj) {
        Empresa empresa = (Empresa) obj;
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(empresa);
        this.entityManager.getTransaction().commit();
    }

    public void update(Object obj) {
        Empresa empresa = (Empresa) obj;
        this.entityManager.getTransaction().begin();
        if (empresa != null && empresa.getId() > 0) {
            this.entityManager.merge(empresa);
        } else {
            this.entityManager.persist(empresa);
        }
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
}
