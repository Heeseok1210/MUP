package com.example.mup.dto.consumer;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ConsumerDto {
    private Long consumerNumber;
    private String consumerId;
    private String consumerPassword;
    private String consumerName;
    private String consumerNickname;
    private String consumerPhoneNumber;
    private String consumerEmail;
}

