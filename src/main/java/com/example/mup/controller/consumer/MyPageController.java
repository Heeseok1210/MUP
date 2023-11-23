package com.example.mup.controller.consumer;

import com.example.mup.service.consumer.MyPageService;
import com.example.mup.service.consumer.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/consumer/*")
public class MyPageController {
    private final ConsumerService consumerService;
    private final MyPageService myPageService;

    @GetMapping("/myPage")
    public void myPage(){}

}
