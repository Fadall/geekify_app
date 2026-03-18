package com.matchserv.skillink.api.mappers;

import com.matchserv.skillink.api.dto.CompanyDto;
import com.matchserv.skillink.data.models.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public CompanyDto toDto(Company company) {
        if (company == null) return null;
        CompanyDto dto = new CompanyDto();
        dto.setId(company.getId());
        dto.setName(company.getName());
        dto.setContactMail(company.getContactMail());
        dto.setWalletId(company.getWallet() != null ? company.getWallet().getId() : null);
        return dto;
    }

    public Company toEntity(CompanyDto dto) {
        if (dto == null) return null;
        Company company = new Company();
        company.setId(dto.getId());
        company.setName(dto.getName());
        company.setContactMail(dto.getContactMail());
        return company;
    }
}
