package br.com.fiap.wtc.work.controller;

import br.com.fiap.wtc.work.UserRole;
import br.com.fiap.wtc.work.entity.User;
import br.com.fiap.wtc.work.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SeedController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/seed")
    public String seed() {

        if (userRepository.findByEmail("admin@wtc.com").isEmpty()) {

            User admin = User.builder()
                    .name("Administrador")
                    .email("admin@wtc.com")
                    .password(passwordEncoder.encode("123123"))
                    .role(UserRole.ADMIN)
                    .build();

            userRepository.save(admin);
        }

        if (userRepository.findByEmail("client@wtc.com").isEmpty()) {

            User client = User.builder()
                    .name("Cliente")
                    .email("client@wtc.com")
                    .password(passwordEncoder.encode("123123"))
                    .role(UserRole.CLIENT)
                    .build();

            userRepository.save(client);
        }

        return "Seed executada com sucesso";
    }
}