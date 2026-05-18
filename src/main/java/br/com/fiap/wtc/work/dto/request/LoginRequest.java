package br.com.fiap.wtc.work.dto.request;

import lombok.Data;

@Data
public class LoginRequest {

    private String email;

    private String password;
}