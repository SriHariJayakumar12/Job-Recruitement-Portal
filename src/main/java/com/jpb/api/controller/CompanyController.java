package com.jpb.api.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jpb.api.entity.Company;
import com.jpb.api.service.CompanyService;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public Company saveCompany(@RequestBody Company company) {
        System.out.println("CompanyService.saveCompany()");
        return companyService.saveCompany(company);
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        System.out.println("CompanyService.getAllCompanies()");
        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable Long id) {
        System.out.println("CompanyService.getCompanyById()");
        return companyService.getCompanyById(id);
    }

    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable Long id, @RequestBody Company company) {
    	System.out.println("CompanyService.updateCompany()");
        return companyService.updateCompany(id, company);
    }

    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable Long id) {
    	System.out.println("CompanyService.deleteCompany()");
        companyService.deleteCompany(id);
        return "Company deleted successfully";
    }
}
