package br.com.fiap.contacts.dto;

import br.com.fiap.contacts.model.Contact;

import java.time.LocalDate;

public record ContactOutputDto(
        Long id,
        String name,
        String email,
        LocalDate birthday
) {

    public ContactOutputDto(Contact contact) {
        this(
                contact.getId(),
                contact.getName(),
                contact.getEmail(),
                contact.getBirthday()
        );
    }
}
