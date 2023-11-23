package com.example.mup.mapper.consumer;

import com.example.mup.dto.consumer.ConsumerDto;
import jdk.jfr.Timespan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ConsumerMapper {
    void insert(ConsumerDto consumerDto);

    Long selectConsumerNumber(@Param("consumerId") String consumerId, @Param("consumerPassword") String consumerPassword);

//    계정찾기
    public ConsumerDto findConsumerInfo(ConsumerDto consumerDto);

//    아이디 중복 검사
    public int checkId(String consumerId);

//    닉네임 중복 검사
    public int checkNickname(String consumerNickname);

//    로그인 실패
    public int loginFail(@Param("consumerId") String consumerId, @Param("consumerPassword") String consumerPassword);
}
