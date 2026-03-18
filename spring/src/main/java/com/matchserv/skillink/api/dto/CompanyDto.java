package com.matchserv.skillink.api.dto;

import lombok.Data;

@Data
public class CompanyDto {
    private Long id;
    private String name;
    private String contactMail;
    private Long walletId; // relation simplifiée
}
