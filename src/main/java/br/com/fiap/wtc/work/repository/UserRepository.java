package br.com.fiap.wtc.work.repository;

import br.com.fiap.wtc.work.UserRole;
import br.com.fiap.wtc.work.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);

    List<User> findByRole(UserRole role);
}