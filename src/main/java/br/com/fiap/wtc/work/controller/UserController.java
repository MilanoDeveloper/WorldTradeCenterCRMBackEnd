package br.com.fiap.wtc.work.controller;

import br.com.fiap.wtc.work.entity.User;
import br.com.fiap.wtc.work.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repository;

    @GetMapping
    public List<User> getAll() {
        return repository.findAll();
    }
}
