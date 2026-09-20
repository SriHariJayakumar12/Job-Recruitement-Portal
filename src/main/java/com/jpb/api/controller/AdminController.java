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
import com.jpb.api.entity.Admin;
import com.jpb.api.service.AdminService;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        System.out.println("AdminController.createAdmin()");
        return adminService.createAdmin(admin);
    }

    @GetMapping
    public List<Admin> getAllAdmins() {
        System.out.println("AdminController.getAllAdmins()");
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable Long id) {
        System.out.println("AdminController.getAdminById()");
        return adminService.getAdminById(id);
    }

    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable Long id,@RequestBody Admin admin) {
        System.out.println("AdminController.updateAdmin()");
        return adminService.updateAdmin(id, admin);
    }

    @DeleteMapping("/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        System.out.println("AdminController.deleteAdmin()");
        adminService.deleteAdmin(id);
        return "Admin deleted successfully";
    }
}
