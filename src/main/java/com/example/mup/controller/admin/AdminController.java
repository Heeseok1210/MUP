package com.example.mup.controller.admin;

import com.example.mup.dto.admin.AdminDto;
import com.example.mup.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminController {
    private  final AdminService adminService;

    @GetMapping("/adminLogin")
    public void adminLogin(Model model){}

    @PostMapping("/adminLogin")
    public RedirectView adminLogin(String adminId, String adminPassword, HttpServletRequest req){
        try {
            Long adminNumber = adminService.adminLogin(adminId, adminPassword);
            req.getSession().setAttribute("adminNumber", adminNumber);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return new RedirectView("/admin/adminLogin");
        }
        return new RedirectView("/admin/playerList");
    }

    @GetMapping("/playerList")
    public void playerList(){}

    @GetMapping("/playerWrite")
    public void playerWrite(){}

    @GetMapping("/playerRead")
    public void playerRead(){}
}
