package com.jpb.api.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jpb.api.entity.Admin;


public interface AdminRepository extends JpaRepository<Admin,Long> {

}
