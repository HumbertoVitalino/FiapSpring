package br.com.fiap.contacts.dao;

import br.com.fiap.contacts.model.Contact;
import jakarta.persistence.EntityManager;

public class ContactDao {

    private EntityManager em;

    public ContactDao(EntityManager em) {
        this.em = em;
    }

    public void save(Contact contact) {
        em.persist(contact);
    }

    public void update(Contact contact) {
        em.merge(contact);
    }

    public void delete(Contact contact) {
        Contact contactDelete = em.find(Contact.class, contact.getId());
        em.remove(contactDelete);
    }
}
