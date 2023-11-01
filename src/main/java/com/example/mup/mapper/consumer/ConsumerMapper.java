package com.example.mup.mapper.consumer;

import com.example.mup.dto.consumer.ConsumerDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ConsumerMapper {
    void insert(ConsumerDto consumerDto);

    Long selectConsumerNumber(@Param("consumerId") String consumerId, @Param("consumerPassword") String consumerPassword);
}
