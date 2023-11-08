package com.example.mup.controller.museum;

import com.example.mup.service.museum.MuseumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/museum/*")
public class MuseumController {
    private final MuseumService museumService;

    @GetMapping("/museumList")
    public void museumList(){}

    @GetMapping("/activePlayerList")
    public void activePlayerList(){}

    @GetMapping("/allPlayerRead")
    public void allPlayerRead(){}


}
