package br.com.fiap.contacts.controller;
import br.com.fiap.contacts.dto.UserOutputDto;
import br.com.fiap.contacts.dto.UserRegisterDto;
import br.com.fiap.contacts.model.User;
import br.com.fiap.contacts.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public Page<UserOutputDto> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserOutputDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserOutputDto save(@RequestBody @Valid UserRegisterDto user) {
        return service.create(user);
    }

    @PutMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public User update(User user) {
        return service.update(user);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
