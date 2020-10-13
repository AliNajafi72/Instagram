package ir.maktabsharif.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
    private static EntityManagerFactory entityManagerFactory;

    private EntityManagerFactorySingleton() {

    }

    public static EntityManagerFactory getEntityManagerFactoryInstance() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("instagram-unit");
        }
        return entityManagerFactory;
    }
}
