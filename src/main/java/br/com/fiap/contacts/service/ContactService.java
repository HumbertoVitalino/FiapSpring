package br.com.fiap.contacts.service;

import br.com.fiap.contacts.model.Contact;
import br.com.fiap.contacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService  {

    @Autowired
    private ContactRepository contactRepository;

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact findById(Long id) {

        Optional<Contact> contactOptional = contactRepository.findById(id);
        if (contactOptional.isPresent()) {
            return contactOptional.get();
        }
        return null;
    }

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public void deleteById(Long id) {
        Optional<Contact> contactOptional = contactRepository.findById(id);

        if (contactOptional.isPresent()) {
            contactRepository.delete(contactOptional.get());
        } else {
            throw new RuntimeException("Contact not found!");
        }
    }

    public List<Contact> findByBirthdayBetween(LocalDate startDate, LocalDate endDate) {
        return contactRepository.findByBirthdayBetween(startDate, endDate);
    }

    public Contact update(Contact contact) {
        Optional<Contact> contactOptional = contactRepository.findById(contact.getId());

        if (contactOptional.isPresent()) {
            return contactRepository.save(contact);
        } else {
            throw new RuntimeException("Contact not found!");
        }
    }
}
