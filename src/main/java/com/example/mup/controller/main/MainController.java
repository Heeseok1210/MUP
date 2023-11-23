package com.example.mup.controller.main;

import com.example.mup.service.main.MainService;
import com.example.mup.vo.PlayerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MainService mainService;

    @GetMapping("/")
    public String main(Model model){
//        레전드 선수
        List<PlayerVo> playerList = mainService.findLegend();
        model.addAttribute("playerList", playerList);

        return "main";
    }
}
