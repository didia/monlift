package me.didia.monlift.helper;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public final class EMF {
    private EntityManagerFactory emfInstance;

    private static EMF emf;

    private EMF() {
    }

    public EntityManagerFactory get() {
        if(emfInstance == null) {
            emfInstance = Persistence.createEntityManagerFactory("transactions-optional");
        }
        return emfInstance;
    }

    public static EMF getInstance() {
        if(emf == null) {
            emf = new EMF();
        }
        return emf;
    }
}