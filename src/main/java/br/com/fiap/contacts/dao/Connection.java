package br.com.fiap.contacts.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connection {

    public static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("contacts");

    public static EntityManager getEntityManager() {
        return EMF.createEntityManager();
    }
}
