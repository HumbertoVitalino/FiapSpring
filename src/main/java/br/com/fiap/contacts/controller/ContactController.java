package br.com.fiap.contacts.controller;

import br.com.fiap.contacts.model.Contact;
import br.com.fiap.contacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactController {

    @Autowired
    private ContactService service;

    @GetMapping("/contacts")
    @ResponseStatus(HttpStatus.OK)
    public List<Contact> findAll() {
        return service.findAll();
    }

    @GetMapping("/contacts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Contact getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/contacts")
    @ResponseStatus(HttpStatus.CREATED)
    public Contact save(@RequestBody Contact contact) {
        return service.save(contact);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Contact update(Contact contact) {
        return service.update(contact);
    }

    @DeleteMapping("/contacts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
