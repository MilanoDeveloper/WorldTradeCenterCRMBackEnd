package br.com.fiap.wtc.work.dto.request;

import lombok.Data;

@Data
public class CreateClientRequest {

    private String name;

    private String email;

    private String phone;

    private String company;

    private String segment;
}
