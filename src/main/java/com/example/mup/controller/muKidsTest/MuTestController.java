package com.example.mup.controller.muKidsTest;

import com.example.mup.service.maker.MakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/MUKidsTest/*")
public class MuTestController {
    private final MakerService makerService;

    @GetMapping("/MUKidsTest")
    public void muKidsTest(){}

}
