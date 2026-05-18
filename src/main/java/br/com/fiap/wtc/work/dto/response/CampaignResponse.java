package br.com.fiap.wtc.work.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CampaignResponse {

    private String id;

    private String title;

    private String description;

    private String status;

    private String targetAudience;

    private String startDate;

    private String endDate;
}
