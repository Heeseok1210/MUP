package com.example.mup.controller.museum;

import com.example.mup.service.museum.MuseumService;
import com.example.mup.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/museum/*")
public class MuseumController {
    private final MuseumService museumService;

    @GetMapping("/list")
    public String museumList(Model model){
//        레전드 선수
        List<PlayerVo> playerList = museumService.findLegend();
        model.addAttribute("playerList", playerList);
        return "museum/museumList";
    }

    @GetMapping("/activeList")
    public String activePlayerList(Model model, HttpServletRequest req, CriteriaAct criteriaAct){
//        현역 선수
        List<PlayerVo> activeList = museumService.findActive(criteriaAct);
        model.addAttribute("activeList", activeList);
        model.addAttribute("pageInfo",new PageActVo(criteriaAct, museumService.getActiveCnt()));
        return "museum/activePlayerList";
    }

    @GetMapping("/read")
    public String allPlayerRead(Long playerNumber, Model model){
        PlayerVo playerVo = museumService.findPlayer(playerNumber);
        museumService.updateReadCnt(playerNumber);
        model.addAttribute("allPlayer", playerVo);
        return "museum/allPlayerRead";
    }

    @GetMapping("legendList")
    public String legendPlayerList(Model model, HttpServletRequest req, Criteria criteria){
//    레전드 선수
        List<PlayerVo> legendList = museumService.findLegendPlayer(criteria);
        model.addAttribute("legendList", legendList);
        model.addAttribute("pageInfo", new PageVo(criteria, museumService.getLegendCnt()));
        return "museum/legendPlayerList";
    }


}
