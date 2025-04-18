package br.com.fiap.contacts;

import br.com.fiap.contacts.dao.Connection;
import br.com.fiap.contacts.dao.ContactDao;
import br.com.fiap.contacts.model.Contact;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class ContactApp {
    public static void main(String[] args) {
        EntityManager em = Connection.getEntityManager();
        //create(em);
        //create(em);
        //create(em);
        //update(em);
        //delete(em);
        //get(em, 5);
        //getAll(em);
        getByEmail(em, "humberto@gmail.com");
    }

    private static void getAll(EntityManager em) {
        ContactDao dao = new ContactDao(em);

        List<Contact> contacts = dao.getAll();
        for(Contact contact : contacts) {
            System.out.println(contact.toString());
        }
    }

    public static void getByEmail(EntityManager em, String email) {
        ContactDao dao = new ContactDao(em);

        List<Contact> contacts = dao.getByEmail(email);
        for(Contact contact : contacts) {
            System.out.println(contact.toString());
        }
    }

    public static void create(EntityManager em) {
        Contact contact = new Contact();
        contact.setName("Humberto Ribeiro");
        contact.setEmail("humberto@gmail.com");
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
