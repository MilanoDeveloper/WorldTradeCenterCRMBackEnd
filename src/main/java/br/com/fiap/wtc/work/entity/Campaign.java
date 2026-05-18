package br.com.fiap.wtc.work.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "campaigns")
public class Campaign {

    @Id
    private String id;

    private String title;

    private String description;

    private String status;

    private String targetAudience;

    private String startDate;

    private String endDate;
}
