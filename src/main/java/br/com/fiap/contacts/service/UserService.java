package br.com.fiap.contacts.service;

import br.com.fiap.contacts.dto.UserOutputDto;
import br.com.fiap.contacts.dto.UserRegisterDto;
import br.com.fiap.contacts.model.User;
import br.com.fiap.contacts.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserOutputDto create(UserRegisterDto user) {

        String cptPassword = new BCryptPasswordEncoder().encode(user.password());
        var entity = new User();
        BeanUtils.copyProperties(user, entity);

        entity.setPassword(cptPassword);
        return new UserOutputDto(repository.save(entity));
    }

    public UserOutputDto findById(Long id) {

        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            return new UserOutputDto(user.get());
        }
        throw new RuntimeException("Unable to find user with id: " + id);
    }

    public Page<UserOutputDto> findAll(Pageable pageable) {
        return repository
                .findAll(pageable)
                .map(UserOutputDto::new);
    }

    public void deleteById(Long id) {
        Optional<User> userOptional = repository.findById(id);

        if (userOptional.isPresent()) {
            repository.delete(userOptional.get());
        }
        throw new RuntimeException("User not found!");
    }

    public User update(User user) {
        Optional<User> userOptional = repository.findById(user.getId());

        if (userOptional.isPresent()) {
            return repository.save(user);
        }
        throw new RuntimeException("User not found!");
    }
}
