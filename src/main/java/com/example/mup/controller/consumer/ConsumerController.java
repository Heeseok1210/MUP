package com.example.mup.controller.consumer;

import com.example.mup.dto.consumer.ConsumerDto;
import com.example.mup.service.consumer.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
@RequestMapping({"/consumer/*"})
public class ConsumerController {
    private final ConsumerService consumerService;

    @GetMapping("/join")
    public void join(){}

    @GetMapping("/login")
    public void login(){}

    @PostMapping("/join")
    public RedirectView join(ConsumerDto consumerDto){
        consumerService.register(consumerDto);
        return new RedirectView("/consumer/login");
    }

    @PostMapping("/login")
    public RedirectView login(String consumerId, String consumerPassword, HttpServletRequest req){
        try {
            Long consumerNumber = consumerService.findConsumerNumber(consumerId, consumerPassword);
            req.getSession().setAttribute("consumerNumber", consumerNumber);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return  new RedirectView("/consumer/login");
        }
        return new RedirectView("/");
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest req){
        req.getSession().invalidate(); //세션 초기화
        return  "/consumer/login";
    }

//    계정찾기
    @GetMapping("/find-id")
    public void find(){}

//    @PostMapping("/find-id"){
//
//    }

}