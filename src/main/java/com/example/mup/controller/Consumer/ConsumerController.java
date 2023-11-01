package com.example.mup.controller.Consumer;

import com.example.mup.service.consumer.ConsumerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/consumer/*"})
public class ConsumerController {
    private final ConsumerService consumerService;

    @GetMapping({"/join"})
    public void join() {
    }

    @GetMapping({"/login"})
    public void login(String consumerId, String consumerPassword) {
        try {
            this.consumerService.findConsumerNumber(consumerId, consumerPassword);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public ConsumerController(final ConsumerService consumerService) {
        this.consumerService = consumerService;
    }
}