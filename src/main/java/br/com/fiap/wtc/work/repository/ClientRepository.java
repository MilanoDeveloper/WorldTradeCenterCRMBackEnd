package br.com.fiap.wtc.work.repository;

import br.com.fiap.wtc.work.entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, String> {
}
