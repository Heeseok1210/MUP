package com.example.mup.controller.admin;

import com.example.mup.dto.museum.PlayerDto;
import com.example.mup.service.admin.AdminFileService;
import com.example.mup.service.admin.AdminService;
import com.example.mup.vo.Criteria;
import com.example.mup.vo.PageVo;
import com.example.mup.vo.PlayerVo;
import com.example.mup.vo.SearchPlayerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/adminR/*")
public class AdminRestController {
    private  final AdminService adminService;
    private final AdminFileService adminFileService;

//    이름이랑 카테고리로 선수 조회
    @GetMapping("/allPlayerList/{page}")
    public Map<String, Object> searchAll(SearchPlayerVo searchPlayerVo, @PathVariable("page") int page, HttpServletRequest req){
    Criteria criteria = new Criteria(page,12);
    Long playerNumber = (Long) req.getSession().getAttribute("playerNumber");
    int total = adminService.findSearchTotal(searchPlayerVo);
    PageVo pageVo = new PageVo(criteria, total);
    Map<String, Object> map = new HashMap<>();
    List<PlayerVo>list = adminService.findAllListByName(searchPlayerVo, criteria, playerNumber != null ? playerNumber : 0);
    map.put("page", pageVo);
    map.put("playerList", list);

    return map;
    }
}
