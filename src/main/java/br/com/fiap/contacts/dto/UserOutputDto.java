package br.com.fiap.contacts.dto;

import br.com.fiap.contacts.model.User;

public record UserOutputDto(
        Long id,
        String name,
        String email
) {
    public UserOutputDto(User user) {
        this(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
