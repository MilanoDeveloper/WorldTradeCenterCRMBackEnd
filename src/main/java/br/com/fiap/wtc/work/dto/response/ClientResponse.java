package br.com.fiap.wtc.work.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientResponse {

    private String id;

    private String name;

    private String email;

    private String phone;

    private String company;

    private String segment;
}
