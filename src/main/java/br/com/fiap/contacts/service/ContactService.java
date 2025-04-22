package br.com.fiap.contacts.service;

import br.com.fiap.contacts.dto.ContactOutputDto;
import br.com.fiap.contacts.dto.ContactRequestDto;
import br.com.fiap.contacts.model.Contact;
import br.com.fiap.contacts.repository.ContactRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService  {

    @Autowired
    private ContactRepository contactRepository;

    public ContactOutputDto save(ContactRequestDto contactRequest) {
        var contact = new Contact();
        BeanUtils.copyProperties(contactRequest, contact);
        return new ContactOutputDto(contactRepository.save(contact));
    }

    public ContactOutputDto findById(Long id) {

        Optional<Contact> contact = contactRepository.findById(id);
        if (contact.isPresent()) {
            return new ContactOutputDto(contact.get());
        }
        throw new RuntimeException("Unable to find contact with id: " + id);
    }

    public Page<ContactOutputDto> findAll(Pageable pageable) {
        return contactRepository
                .findAll(pageable)
                .map(ContactOutputDto::new);
    }

    public void deleteById(Long id) {
        Optional<Contact> contactOptional = contactRepository.findById(id);

        if (contactOptional.isPresent()) {
            contactRepository.delete(contactOptional.get());
        }

        throw new RuntimeException("Contact not found!");
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
