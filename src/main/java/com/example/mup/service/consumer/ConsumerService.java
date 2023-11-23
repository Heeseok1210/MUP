package com.example.mup.service.consumer;

import com.example.mup.dto.consumer.ConsumerDto;
import com.example.mup.mapper.consumer.ConsumerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    public int checkConsumerId(String consumerId){
        if(consumerId == null){
            throw new IllegalArgumentException("아이디 누락");
        }
        return consumerMapper.checkId(consumerId);
    }

    @Transactional(readOnly = true)
    public int checkConsumerNickname(String consumerNickname){
        if(consumerNickname == null){
            throw new IllegalArgumentException("닉네임 누락");
        }
        return consumerMapper.checkNickname(consumerNickname);
    }

    @Transactional(readOnly = true)
    public int loginFail(String consumerId, String consumerPassword){
        if (consumerId == null){
            throw new IllegalArgumentException("아이디 누락");
        }else if (consumerPassword == null){
            throw new IllegalArgumentException("비밀번호 누락");
        }
        return consumerMapper.loginFail(consumerId, consumerPassword);
    }
}