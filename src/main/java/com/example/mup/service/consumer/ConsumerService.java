package com.example.mup.service.consumer;

import com.example.mup.dto.consumer.ConsumerDto;
import com.example.mup.mapper.consumer.ConsumerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsumerService {
    private final ConsumerMapper consumerMapper;

//    회원 등록
    public void register(ConsumerDto consumerDto){
       if (consumerDto == null){throw new IllegalArgumentException("회원 정보 누락!");}
       consumerMapper.insert(consumerDto);
    }

//    회원 번호 조회하기(아이디, 패스워드)
    public Long findConsumerNumber(String consumerId, String consumerPassword){
        if (consumerId == null || consumerPassword == null){throw new IllegalArgumentException("아이디, 패스워드 누락!");}

        return Optional.ofNullable(consumerMapper.selectConsumerNumber(consumerId, consumerPassword))
                .orElseThrow(() -> {throw new IllegalArgumentException("존재하지 않는 회원입니다.");});
    }
}