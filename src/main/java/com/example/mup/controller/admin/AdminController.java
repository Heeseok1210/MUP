package com.example.mup.controller.admin;

import com.example.mup.dto.museum.PlayerDto;
import com.example.mup.service.admin.AdminFileService;
import com.example.mup.service.admin.AdminService;
import com.example.mup.vo.Criteria;
import com.example.mup.vo.PageVo;
import com.example.mup.vo.PlayerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminController {
    private  final AdminService adminService;
    private final AdminFileService adminFileService;

    @GetMapping("/adminLogin")
    public void adminLogin(Model model){}

    @PostMapping("/adminLogin")
    public RedirectView adminLogin(String adminId, String adminPassword, HttpServletRequest req){
        try {
            Long adminNumber = adminService.adminLogin(adminId, adminPassword);
            req.getSession().setAttribute("adminNumber", adminNumber);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return new RedirectView("/admin/adminLogin");
        }
        return new RedirectView("/admin/list");
    }

//    로그아웃
    @GetMapping("/adminLogout")
    public String logout(HttpServletRequest req){
        req.getSession().invalidate();
        return "/main";
    }

    @GetMapping("/list")
    public String showPlayerList(Model model, HttpServletRequest req, Criteria criteria){
        List<PlayerVo> playerList = adminService.findAll(criteria);
        Long adminNumber = (Long)req.getSession().getAttribute("adminNumber");
        model.addAttribute("playerList", playerList);
        model.addAttribute("pageInfo", new PageVo(criteria, adminService.getTotalPlayer()));

        return adminNumber == null ? "admin/adminLogin" : "admin/playerList";
    }

    @GetMapping("/write")
    public String playerWrite(HttpServletRequest req){
        Long adminNumber = (Long)req.getSession().getAttribute("adminNumber");
        return adminNumber == null ? "admin/adminLogin" : "admin/playerWrite";
    }

    @PostMapping("/write")
    public RedirectView playerWrite(PlayerDto playerDto, HttpServletRequest req, RedirectAttributes redirectAttributes
            , @RequestParam("playerFile") List<MultipartFile> files){
//        RedirectAttributes는 리다이렠트 전용 Model객체라고 생각
        Long adminNumber = (Long) req.getSession().getAttribute("adminNumber");
        playerDto.setAdminNumber(adminNumber);
        adminService.register(playerDto);


//        쿼리스트링으로 데이터 전송(url에 쿼리스트링이 생김)
//        redirectAttributes.addAttribute("playerNumber", playerDto.getPlayerNumber());

//        플레쉬를 사용하여 데이터 전송
        redirectAttributes.addFlashAttribute("playerNumber", playerDto.getPlayerNumber());

        if (files != null){
            try {
                adminFileService.registerAndSaveFiles(files, playerDto.getPlayerNumber());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return new RedirectView("/admin/list");
    }

    @GetMapping("/read")
    public String playerRead(Long playerNumber, Model model){
        PlayerVo playerVo = adminService.findPlayer(playerNumber);
        model.addAttribute("player", playerVo);
        return "admin/playerRead";
    }

    @GetMapping("/modify")
    public String playerModify(Long playerNumber, Model model) {
        PlayerVo playerVo = adminService.findPlayer(playerNumber);
        model.addAttribute("player", playerVo);
        return "admin/playerModify";
    }

    @PostMapping("modify")
    public RedirectView playerModify(PlayerDto playerDto, RedirectAttributes redirectAttributes,
                                     @RequestParam("playerFile")List<MultipartFile> files){
        try {
            adminService.modifyPlayer(playerDto, files);
        } catch (Exception e) {
            e.printStackTrace();
        }
        redirectAttributes.addAttribute("playerNumber", playerDto.getPlayerNumber());
        return new RedirectView("/admin/read");
    }

    @GetMapping("/remove")
    public RedirectView playerRemove(Long playerNumber){
        adminService.removePlayer(playerNumber);
        return new RedirectView("/admin/list");
    }
}
