package com.example.mup.controller.consumer;

import com.example.mup.dto.consumer.ConsumerDto;
import com.example.mup.service.consumer.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/consumers/*"})
public class ConsumerRestController {
    private final ConsumerService consumerService;

    @GetMapping("/checkId")
    public int checkConsumerId(String consumerId){return consumerService.checkConsumerId(consumerId);}

    @GetMapping("/checkNickname")
    public int checkConsumerNickname(String consumerNickname){return consumerService.checkConsumerNickname(consumerNickname);}

    @GetMapping("/loginFail")
    public int loginFail(String consumerId, String consumerPassword){return consumerService.loginFail(consumerId, consumerPassword);}

}