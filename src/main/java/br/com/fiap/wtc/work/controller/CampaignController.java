package br.com.fiap.wtc.work.controller;

import br.com.fiap.wtc.work.dto.request.CreateCampaignRequest;
import br.com.fiap.wtc.work.entity.Campaign;
import br.com.fiap.wtc.work.service.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campaigns")
@RequiredArgsConstructor
public class CampaignController {

    private final CampaignService service;

    @GetMapping
    public ResponseEntity<List<Campaign>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campaign> getById(
            @PathVariable String id
    ) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Campaign> create(
            @RequestBody CreateCampaignRequest request
    ) {
        return ResponseEntity.ok(service.create(request));
    }
}
