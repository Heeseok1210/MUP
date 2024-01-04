package com.example.mup.controller.museum;

import com.example.mup.service.museum.MuseumService;
import com.example.mup.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/museumR/*")
public class MuseumRestController {
    private final MuseumService museumService;

//    이름으로 선수 조회
    @GetMapping("/playerSearchList/{page}")
    public Map<String, Object> searchPlayer(SearchPlayerVo searchPlayerVo, @PathVariable("page") int page, HttpServletRequest req){
        CriteriaAct criteriaAct = new CriteriaAct(page, 11);
        Long playerNumber = (Long) req.getSession().getAttribute("playerNumber");
        int total = museumService.findSearchTotal(searchPlayerVo);
        PageActVo pageActVo = new PageActVo(criteriaAct, total);
        Map<String, Object> map = new HashMap<>();
        List<PlayerVo> list = museumService.findPlayerListByName(searchPlayerVo, criteriaAct, playerNumber != null ? playerNumber : 0);
        map.put("page",pageActVo);
        map.put("playerList", list);

        return map;
    }

//    이름이랑 카테고리로 선수 조회(레전드)
    @GetMapping("/legendPlayerList/{page}")
    public Map<String, Object> searchLegend(SearchPlayerVo searchPlayerVo, @PathVariable("page") int page, HttpServletRequest req){
        Criteria criteria = new Criteria(page,12);
        Long playerNumber = (Long) req.getSession().getAttribute("playerNumber");
        int total = museumService.findSearchLTotal(searchPlayerVo);
        PageVo pageVo = new PageVo(criteria, total);
        Map<String, Object> map = new HashMap<>();
        List<PlayerVo>list = museumService.findLegendListByName(searchPlayerVo, criteria, playerNumber != null ? playerNumber : 0);
        map.put("page", pageVo);
        map.put("playerList", list);

        return map;
    }
}
