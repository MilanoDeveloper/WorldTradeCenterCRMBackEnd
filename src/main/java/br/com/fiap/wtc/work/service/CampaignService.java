package br.com.fiap.wtc.work.service;

import br.com.fiap.wtc.work.dto.request.CreateCampaignRequest;
import br.com.fiap.wtc.work.entity.Campaign;
import br.com.fiap.wtc.work.repository.CampaignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CampaignService {

    private final CampaignRepository repository;

    private final NotificationService notificationService;

    public List<Campaign> getAll() {
        return repository.findAll();
    }

    public Campaign getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campanha não encontrada"));
    }

    public Campaign create(CreateCampaignRequest request) {

        Campaign campaign = Campaign.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .status(request.getStatus())
                .targetAudience(request.getTargetAudience())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .build();

        Campaign savedCampaign = repository.save(campaign);

        notificationService.createCampaignNotification(
                savedCampaign.getTitle(),
                savedCampaign.getDescription()
        );

        return savedCampaign;
    }
}