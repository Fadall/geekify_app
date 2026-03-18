package com.matchserv.skillink.application.impl;

import com.matchserv.skillink.application.CompanyService;
import com.matchserv.skillink.data.models.Company;
import com.matchserv.skillink.data.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepo;

    @Override
    public Company save(Company company) {
        return companyRepo.save(company);
    }

    @Override
    public void delete(Company company) {
        companyRepo.delete(company);
    }

    @Override
    public Company findById(Long id) {
        return companyRepo.findById(id).orElse(null);
    }

    @Override
    public List<Company> findAll() {
        return companyRepo.findAll();
    }
}
