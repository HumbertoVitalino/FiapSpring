package br.com.fiap.contacts;

import br.com.fiap.contacts.model.Contact;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class ContactApp {
    public static void main(String[] args) {
        Contact contact = new Contact();
        contact.setName("John Doe");
        contact.setEmail("john@doe.com");
        contact.setDateOfBirth(LocalDate.of(1990, 1, 1));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contacts");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(contact);
        em.getTransaction().commit();
    }
}
