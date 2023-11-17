package com.example.mup.mapper.admin;

import com.example.mup.dto.museum.PlayerFileDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
class AdminFileMapperTest {

    @Autowired
    private AdminFileMapper adminFileMapper;
    private PlayerFileDto playerFileDto;

    @BeforeEach
    void setUp(){
        playerFileDto = new PlayerFileDto();
        playerFileDto.setPlayerFileName("aaaa");
        playerFileDto.setPlayerFileUuid("testUUID");
        playerFileDto.setPlayerFileUploadPath("/23/23/23");
        playerFileDto.setPlayerNumber(215L);
    }

    @Test
    void insertPlayerFile() {
        adminFileMapper.insertPlayerFile(playerFileDto);
        assertThat(adminFileMapper.selectList(playerFileDto.getPlayerNumber()).size()).isNotEqualTo(0);
        System.out.println("playerFileDto = " + playerFileDto);
    }

    @Test
    void deletePlayerFile() {
        adminFileMapper.insertPlayerFile(playerFileDto);
        adminFileMapper.deletePlayerFile(playerFileDto.getPlayerNumber());
        assertThat(adminFileMapper.selectList(playerFileDto.getPlayerNumber()).size()).isNotEqualTo(0);
    }

    @Test
    void selectList() {
    }
}