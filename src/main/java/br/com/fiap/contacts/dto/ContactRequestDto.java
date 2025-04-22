package br.com.fiap.contacts.dto;

import br.com.fiap.contacts.model.Contact;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ContactRequestDto(
        Long id,

        @NotBlank(message = "name should be not empty!")
        String name,

        @NotBlank
        @Size(min = 10, max = 15)
        String password,

        @NotBlank
        @Email
        String email,

        @NotNull
        LocalDate birthday
) {
    public ContactRequestDto(Contact contact) {
        this(
                contact.getId(),
                contact.getName(),
                contact.getPassword(),
                contact.getEmail(),
                contact.getBirthday()
        );
    }
}
