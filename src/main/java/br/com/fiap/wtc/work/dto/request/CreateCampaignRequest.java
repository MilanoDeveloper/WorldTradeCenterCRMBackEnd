package br.com.fiap.wtc.work.dto.request;

import lombok.Data;

@Data
public class CreateCampaignRequest {

    private String title;

    private String description;

    private String status;

    private String targetAudience;

    private String startDate;

    private String endDate;
}
