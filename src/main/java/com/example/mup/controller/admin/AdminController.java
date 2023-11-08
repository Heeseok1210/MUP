package com.example.mup.controller.admin;

import com.example.mup.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("admin/*")
public class AdminController {
    private  final AdminService adminService;

    @GetMapping("/adminLogin")
    public void adminLogin(){}

    @GetMapping("/playerList")
    public void playerList(){}

    @GetMapping("/playerWrite")
    public void playerWrite(){}

    @GetMapping("/playerRead")
    public void playerRead(){}
}
