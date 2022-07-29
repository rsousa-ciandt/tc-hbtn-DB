package models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class BaseModel {
    protected EntityManager entityManager;
    protected EntityManagerFactory entityManagerFactory;

    public BaseModel(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    protected void generateEntityManager() {
        this.entityManager = this.entityManagerFactory.createEntityManager();
    }

    protected void closeEntityManager() {
        this.entityManager.close();
    }

    protected void beginTransaction() {
        System.out.println("Iniciando a transação");
        this.entityManager.getTransaction().begin();
    }

    protected void commitTransaction() {
        this.entityManager.getTransaction().commit();
    }

}
