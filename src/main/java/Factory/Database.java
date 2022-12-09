/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Database {

    private EntityManager entityManager;

    private static Database INSTANCE = null;

    public static Database getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Database();
        }

        return INSTANCE;
    }

    /**
     * Construtor da classe. - No padrão SINGLETON ele deve ser PRIVADO - Só
     * pode ser chamado pelo método getInstance() - O método getInstance()
     * gerencia a regra SINGLETON, que permite apenas uma instancia do objeto
     * Database
     */
    private Database() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("gestao");
        this.entityManager = factory.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
