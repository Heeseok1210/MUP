package com.example.mup.controller.maker;

import com.example.mup.service.maker.MakerService;
import com.example.mup.service.museum.MuseumService;
import com.example.mup.vo.PlayerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/maker/*")
public class MakerController {
    private final MakerService makerService;

    @GetMapping("/squadMaker")
    public String squadMaker(Long playerNumber, Model model){
        List<PlayerVo> playerList = makerService.findAllPlayer(playerNumber);
        model.addAttribute("playerList", playerList);

        return "maker/squadMaker";
    }
}
