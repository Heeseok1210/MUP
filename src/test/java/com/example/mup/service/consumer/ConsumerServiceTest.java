package com.example.mup.service.consumer;

import com.example.mup.dto.consumer.ConsumerDto;
import com.example.mup.mapper.consumer.ConsumerMapper;
import org.assertj.core.api.AbstractThrowableAssert;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith({MockitoExtension.class})
class ConsumerServiceTest {
    @Mock
    private ConsumerMapper consumerMapper;
    @InjectMocks
    private ConsumerService consumerService;
    private ConsumerDto consumerDto;

    @BeforeEach
    void setUp() {
        consumerDto = new ConsumerDto();
        consumerDto.setConsumerId("testId");
        consumerDto.setConsumerPassword("1234");
        consumerDto.setConsumerName("윤희석");
        consumerDto.setConsumerNickname("유니썩마딕");
        consumerDto.setConsumerEmail("test@gmail.com");
        consumerDto.setConsumerPhoneNumber("01012341234");
    }

    @Test
    @DisplayName("회원 등록")
    void register(){
        doNothing().when(consumerMapper).insert(any(ConsumerDto.class));

        consumerService.register(consumerDto);

        verify(consumerMapper, times(1)).insert(consumerDto);
    }

    @Test
    @DisplayName("회원 번호 조회 : 존재하지 않는 회원 예외 검사")
    void findConsumerNumberException(){
        doReturn(null).when(consumerMapper).selectConsumerNumber(any(String.class), any(String.class));

        assertThatThrownBy(() -> consumerService.findConsumerNumber("a", "a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("존재하지");
    }

    @Test
    @DisplayName("회원 번호 조회")
    void findConsumerNumber(){
        doReturn(1L).when(consumerMapper).selectConsumerNumber(any(String.class), any(String.class));

        Long consumerNumber = consumerService.findConsumerNumber("test", "1234");

        assertThat(consumerNumber).isEqualTo(1L);
    }
}