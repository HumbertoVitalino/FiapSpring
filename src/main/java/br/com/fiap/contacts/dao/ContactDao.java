package br.com.fiap.contacts.dao;

import br.com.fiap.contacts.model.Contact;
import jakarta.persistence.EntityManager;

import java.util.List;

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

    public void getContact(int id) {
        Contact contact = em.find(Contact.class, id);

        if (contact == null) {
            log("contact not found");
        }

        log(contact.toString());
    }

    public List<Contact> getAll() {
        String query = "SELECT c FROM Contact c ORDER BY name DESC";
        return em.createQuery(query).getResultList();
    }

    public List<Contact> getByEmail(String email) {
        String query = "SELECT c FROM Contact c WHERE c.email = :email";
        return em.createQuery(query, Contact.class).setParameter("email", email).getResultList();
    }

    public List<Contact> getByName(String name) {
        String query = "SELECT c FROM Contact c WHERE c.name = :name";
        return em.createQuery(query, Contact.class).setParameter("name", name).getResultList();
    }

    public void log(String message) {
        System.out.println(message);
    }
}
