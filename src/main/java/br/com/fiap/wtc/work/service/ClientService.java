package br.com.fiap.wtc.work.service;

import br.com.fiap.wtc.work.dto.request.CreateClientRequest;
import br.com.fiap.wtc.work.entity.Client;
import br.com.fiap.wtc.work.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    public List<Client> getAll() {
        return repository.findAll();
    }

    public Client getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Client create(CreateClientRequest request) {

        Client client = Client.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .company(request.getCompany())
                .segment(request.getSegment())
                .build();

        return repository.save(client);
    }
}
