package com.matchserv.skillink.api.controllers;

import com.matchserv.skillink.api.dto.CompanyDto;
import com.matchserv.skillink.api.mappers.CompanyMapper;
import com.matchserv.skillink.data.models.Company;
import com.matchserv.skillink.data.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @GetMapping
    public List<CompanyDto> getAll() {
        return companyRepository.findAll().stream()
                .map(companyMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> getById(@PathVariable Long id) {
        return companyRepository.findById(id)
                .map(companyMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CompanyDto> create(@RequestBody CompanyDto dto) {
        Company company = companyMapper.toEntity(dto);
        Company saved = companyRepository.save(company);
        return ResponseEntity.ok(companyMapper.toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyDto> update(@PathVariable Long id, @RequestBody CompanyDto dto) {
        return companyRepository.findById(id)
                .map(existing -> {
                    existing.setName(dto.getName());
                    existing.setContactMail(dto.getContactMail());
                    Company updated = companyRepository.save(existing);
                    return ResponseEntity.ok(companyMapper.toDto(updated));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!companyRepository.existsById(id)) return ResponseEntity.notFound().build();
        companyRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
