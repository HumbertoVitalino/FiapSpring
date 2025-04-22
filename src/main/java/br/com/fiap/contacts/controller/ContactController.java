package br.com.fiap.contacts.controller;

import br.com.fiap.contacts.dto.ContactOutputDto;
import br.com.fiap.contacts.dto.ContactRequestDto;
import br.com.fiap.contacts.model.Contact;
import br.com.fiap.contacts.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<ContactOutputDto> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/contacts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContactOutputDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/contacts")
    @ResponseStatus(HttpStatus.CREATED)
    public ContactOutputDto save(@RequestBody @Valid ContactRequestDto contact) {
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
