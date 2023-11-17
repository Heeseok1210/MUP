package com.example.mup.mapper.admin;

import com.example.mup.dto.admin.AdminDto;
import com.example.mup.dto.consumer.ConsumerDto;
import com.example.mup.dto.museum.PlayerDto;
import com.example.mup.mapper.consumer.ConsumerMapper;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AdminMapperTest {

    @Autowired
    private ConsumerMapper consumerMapper;

    @Autowired
    private AdminMapper adminMapper;

    private PlayerDto playerDto;
    private AdminDto adminDto;
    private ConsumerDto consumerDto;

//    @BeforeEach
//    void setUp() {
//        consumerDto = new ConsumerDto();
//        consumerDto.setConsumerId("testId");
//        consumerDto.setConsumerPassword("1234");
//        consumerDto.setConsumerName("윤희석");
//        consumerDto.setConsumerNickname("유니썩마딕");
//        consumerDto.setConsumerEmail("test@gmail.com");
//        consumerDto.setConsumerPhoneNumber("01012341234");
//        consumerMapper.insert(consumerDto);
//
//        playerDto = new PlayerDto();
//        playerDto.setPlayerName("웨인 루니");
//        playerDto.setPlayerEnter(568L);
//        playerDto.setPlayerTotalScore(268L);
//        playerDto.setPlayerOverall(99L);
//        playerDto.setPlayerBacknumber(10L);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Date birthdate = dateFormat.parse("1990-01-01");
//            playerDto.setPlayerBirth(birthdate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        playerDto.setPlayerContent("전설입니둥!");
//        playerDto.setFameNumber(1L);
//        playerDto.setWithNumber(2L);
//        playerDto.setPositionNumber(4L);
//        playerDto.setAdminNumber(1L);
//        adminMapper.insertPlayer(playerDto);
//        System.out.println("playerDto = " + playerDto);
//    }

    @Test
    void selectAdminNumber() {

    }

    @Test
    void insertPlayer() {

    }

    @Test
    void deletePlayer() {
        adminMapper.deletePlayer(playerDto.getPlayerNumber());
        assertThat(adminMapper.selectPlayer(playerDto.getPlayerNumber())).isNull();
    }

//    @Test
//    void updatePlayer() {
//        PlayerDto updatedPlayerDto = new PlayerDto();
//        updatedPlayerDto.setPlayerNumber(playerDto.getPlayerNumber());
//        updatedPlayerDto.setPlayerName("웨인루니");
//        updatedPlayerDto.setPlayerEnter(250L);
//        updatedPlayerDto.setPlayerTotalScore(104L);
//        updatedPlayerDto.setPlayerOverall(98L);
//        updatedPlayerDto.setPlayerBacknumber(7L);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Date birthdate = dateFormat.parse("1990-01-02");
//            updatedPlayerDto.setPlayerBirth(birthdate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        updatedPlayerDto.setPlayerContent("siu!!!!");
//        updatedPlayerDto.setFameNumber(1L);
//        updatedPlayerDto.setWithNumber(2L);
//        updatedPlayerDto.setPositionNumber(4L);
//        updatedPlayerDto.setAdminNumber(1L);
//
//        adminMapper.updatePlayer(updatedPlayerDto);
//    }


    @Test
    void selectAllPlayer() {
//        int beforeSize = adminMapper.selectAllPlayer().size();
//        adminMapper.insertPlayer(playerDto);
//        assertThat(adminMapper.selectAllPlayer().size()).isEqualTo(beforeSize+1);
    }
}
