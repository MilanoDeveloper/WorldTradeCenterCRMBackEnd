package br.com.fiap.wtc.work.controller;

import br.com.fiap.wtc.work.dto.request.CreateClientRequest;
import br.com.fiap.wtc.work.entity.Client;
import br.com.fiap.wtc.work.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @GetMapping
    public ResponseEntity<List<Client>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(
            @PathVariable String id
    ) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Client> create(
            @RequestBody CreateClientRequest request
    ) {
        return ResponseEntity.ok(service.create(request));
    }
}
