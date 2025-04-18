package br.com.fiap.contacts.dao;

import br.com.fiap.contacts.model.TypeContact;
import jakarta.persistence.EntityManager;

public class TypeContactDao {

    private EntityManager em;

    public TypeContactDao(EntityManager em) {
        this.em = em;
    }

    public void save(TypeContact contact) {
        em.persist(contact);
    }
}
