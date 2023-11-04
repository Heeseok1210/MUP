package com.example.mup.mapper.consumer;

import com.example.mup.dto.consumer.ConsumerDto;
import lombok.extern.slf4j.Slf4j;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
class ConsumerMapperTest {
    @Autowired
    private ConsumerMapper consumerMapper;
    private ConsumerDto consumerDto;

    @BeforeEach
    void setUp(){
        consumerDto = new ConsumerDto();
        consumerDto.setConsumerId("testId");
        consumerDto.setConsumerPassword("1234");
        consumerDto.setConsumerName("윤희석");
        consumerDto.setConsumerNickname("유니썩마딕");
        consumerDto.setConsumerEmail("test@gmail.com");
        consumerDto.setConsumerPhoneNumber("01012341234");
    }

    @Test
    @DisplayName("회원 정보, 회원 번호 조회")
    void insert() {
        consumerMapper.insert(consumerDto);
        assertThat(consumerMapper.selectConsumerNumber(consumerDto.getConsumerId(), consumerDto.getConsumerPassword()))
                .isEqualTo(consumerDto.getConsumerNumber());
    }
}