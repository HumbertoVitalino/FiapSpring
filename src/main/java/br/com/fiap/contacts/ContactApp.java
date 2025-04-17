package br.com.fiap.contacts;

import br.com.fiap.contacts.dao.Connection;
import br.com.fiap.contacts.dao.ContactDao;
import br.com.fiap.contacts.model.Contact;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class ContactApp {
    public static void main(String[] args) {
        EntityManager em = Connection.getEntityManager();
        //create(em);
        //update(em);
        //delete(em);
        get(em, 5);
    }

    public static void create(EntityManager em) {
        Contact contact = new Contact();
        contact.setName("Gabriela Ribeiro");
        contact.setEmail("gabriela@ribeiro.com");
        contact.setDateOfBirth(LocalDate.of(2003, 7, 7));

        ContactDao dao = new ContactDao(em);

        em.getTransaction().begin();
        dao.save(contact);
        em.getTransaction().commit();
    }

    public static void update(EntityManager em) {
        Contact contact = new Contact();
        contact.setId(3L);
        contact.setName("Gabriela Ribeiro");
        contact.setEmail("gabriela.ribeiro@gmail.com");
        contact.setDateOfBirth(LocalDate.of(2003, 7, 7));

        ContactDao dao = new ContactDao(em);

        em.getTransaction().begin();
        dao.update(contact);
        em.getTransaction().commit();
    }

    public static void delete(EntityManager em) {
        Contact contact = new Contact();
        contact.setId(3L);

        ContactDao dao = new ContactDao(em);

        em.getTransaction().begin();
        dao.delete(contact);
        em.getTransaction().commit();
    }

    public static void get(EntityManager em, int id) {
        ContactDao dao = new ContactDao(em);

        em.getTransaction().begin();
        dao.getContact(id);
        em.getTransaction().commit();
    }
}
