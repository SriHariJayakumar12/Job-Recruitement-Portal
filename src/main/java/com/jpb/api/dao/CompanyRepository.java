package com.jpb.api.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jpb.api.entity.Company;

public interface CompanyRepository extends JpaRepository<Company,Long>{

}
