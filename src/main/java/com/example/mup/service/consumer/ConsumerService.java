package com.example.mup.service.consumer;

import com.example.mup.dto.consumer.ConsumerDto;
import com.example.mup.mapper.consumer.ConsumerMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsumerService {
    private final ConsumerMapper consumerMapper;

    public void register(ConsumerDto consumerDto) {
        if (consumerDto == null) {
            throw new IllegalArgumentException("회원 정보 누락!");
        } else {
            this.consumerMapper.insert(consumerDto);
        }
    }

    public Long findConsumerNumber(String consumerId, String consumerPassword) throws IllegalArgumentException {
        if (consumerId != null && consumerPassword != null) {
            return (Long) Optional.ofNullable(this.consumerMapper.selectConsumerNumber(consumerId, consumerPassword)).orElseThrow(() -> {
                throw new IllegalArgumentException("존재하지 않는 회원입니다.");
            });
        } else {
            throw new IllegalArgumentException("아이디, 패스워드 누락");
        }
    }

    public ConsumerService(final ConsumerMapper consumerMapper) {
        this.consumerMapper = consumerMapper;
    }
}