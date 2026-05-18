package br.com.fiap.wtc.work.service;
import br.com.fiap.wtc.work.dto.request.LoginRequest;
import br.com.fiap.wtc.work.dto.response.LoginResponse;
import br.com.fiap.wtc.work.dto.response.UserResponse;
import br.com.fiap.wtc.work.entity.User;
import br.com.fiap.wtc.work.repository.UserRepository;
import br.com.fiap.wtc.work.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        boolean validPassword = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!validPassword) {
            throw new RuntimeException("Senha inválida");
        }

        String token = jwtService.generateToken(user.getEmail());

        return LoginResponse.builder()
                .token(token)
                .user(
                        UserResponse.builder()
                                .id(user.getId())
                                .name(user.getName())
                                .email(user.getEmail())
                                .role(user.getRole().toString())
                                .build()
                )
                .build();
    }
}
