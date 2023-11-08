package com.example.mup.controller.maker;

import com.example.mup.service.maker.MakerService;
import com.example.mup.service.museum.MuseumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/maker/*")
public class MakerController {
    private final MakerService makerService;

    @GetMapping("/squadMaker")
    public void squadMaker(){}
}
