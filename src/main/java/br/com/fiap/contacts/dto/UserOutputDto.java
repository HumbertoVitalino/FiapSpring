package br.com.fiap.contacts.dto;

import br.com.fiap.contacts.model.User;
import br.com.fiap.contacts.model.UserRoles;

public record UserOutputDto(
        Long id,
        String name,
        String email,
        UserRoles role
) {
    public UserOutputDto(User user) {
        this(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }
}
