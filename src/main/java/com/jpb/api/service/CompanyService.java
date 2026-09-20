package com.jpb.api.service;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jpb.api.dao.CompanyRepository;
import com.jpb.api.entity.Company;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company saveCompany(Company company) {
        System.out.println("CompanyService.saveCompany()");
        company.setCreatedAt(LocalDateTime.now());
        company.setUpdatedAt(LocalDateTime.now());
        company.setActive(true);
        return companyRepository.save(company);
    }

    public List<Company> getAllCompanies() {
        System.out.println("CompanyService.getAllCompanies()");
        return companyRepository.findAll();
    }

    public Company getCompanyById(Long id) {
        System.out.println("CompanyService.getCompanyById()");
        return companyRepository.findById(id).orElseThrow(() ->
                        new RuntimeException("Company not found"));
    }

    public Company updateCompany(Long id,Company updatedCompany) {
        System.out.println("CompanyService.updateCompany()");
        Company company = companyRepository.findById(id).orElseThrow(() ->
                        new RuntimeException("Company not found"));

        company.setCompanyName(updatedCompany.getCompanyName());
        company.setEmail(updatedCompany.getEmail());
        company.setPhoneNumber(updatedCompany.getPhoneNumber());
        company.setWebsite(updatedCompany.getWebsite());
        company.setIndustry(updatedCompany.getIndustry());
        company.setLocation(updatedCompany.getLocation());
        company.setDescription(updatedCompany.getDescription());
        company.setLogoUrl(updatedCompany.getLogoUrl());
        company.setUpdatedAt(LocalDateTime.now());

        return companyRepository.save(company);
    }

    public void deleteCompany(Long id) {
        System.out.println("CompanyService.deleteCompany()");
        Company company = companyRepository.findById(id).orElseThrow(() ->
                        new RuntimeException("Company not found"));
        company.setActive(false);
        company.setUpdatedAt(LocalDateTime.now());
        companyRepository.save(company);
    }
}