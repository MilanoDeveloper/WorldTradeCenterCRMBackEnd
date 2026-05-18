package br.com.fiap.wtc.work.repository;

import br.com.fiap.wtc.work.entity.Campaign;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CampaignRepository extends MongoRepository<Campaign, String> {
}
