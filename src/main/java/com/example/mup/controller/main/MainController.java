package com.example.mup.controller.main;

import com.example.mup.service.main.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/fragment/*")
public class MainController {
    private final MainService mainService;

    @GetMapping("/main")
    public void main(){
    }
}
