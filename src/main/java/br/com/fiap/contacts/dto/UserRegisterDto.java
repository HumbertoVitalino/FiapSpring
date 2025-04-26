package br.com.fiap.contacts.dto;

import br.com.fiap.contacts.model.UserRoles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRegisterDto(

        @NotBlank
        String name,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Size(min = 6, max = 20)
        String password,
        UserRoles role
) {
}
