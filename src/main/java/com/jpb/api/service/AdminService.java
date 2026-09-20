package com.jpb.api.service;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jpb.api.dao.AdminRepository;
import com.jpb.api.entity.Admin;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin createAdmin(Admin admin) {
        System.out.println("AdminService.createAdmin()");
        admin.setCreatedAt(LocalDateTime.now());
        admin.setUpdatedAt(LocalDateTime.now());
        admin.setActive(true);
        return adminRepository.save(admin);
    }

    public List<Admin> getAllAdmins() {
        System.out.println("AdminService.getAllAdmins()");
        return adminRepository.findAll();
    }

    public Admin getAdminById(Long id) {
        System.out.println("AdminService.getAdminById()");
        return adminRepository.findById(id).orElseThrow(() ->
                        new RuntimeException("Admin not found"));
    }

    public Admin updateAdmin(Long id, Admin updatedAdmin) {
        System.out.println("AdminService.updateAdmin()");
        Admin admin = adminRepository.findById(id).orElseThrow(() ->
                        new RuntimeException("Admin not found"));
        admin.setName(updatedAdmin.getName());
        admin.setEmail(updatedAdmin.getEmail());
        admin.setPhoneNumber(updatedAdmin.getPhoneNumber());
        admin.setUpdatedAt(LocalDateTime.now());
        return adminRepository.save(admin);
    }

    public void deleteAdmin(Long id) {
        System.out.println("AdminService.deleteAdmin()");
        Admin admin = adminRepository.findById(id).orElseThrow(() ->
                        new RuntimeException("Admin not found"));
        admin.setActive(false);
        admin.setUpdatedAt(LocalDateTime.now());
        adminRepository.save(admin);
    }
}