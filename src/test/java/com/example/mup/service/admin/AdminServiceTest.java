package com.example.mup.service.admin;

import com.example.mup.dto.museum.PlayerDto;
import com.example.mup.mapper.admin.AdminMapper;
import com.example.mup.vo.PlayerVo;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AdminServiceTest {
    @Mock
    private AdminMapper adminMapper;
    @InjectMocks
    private AdminService adminService;
    private PlayerDto playerDto;
    private PlayerVo playerVo;

//    @BeforeEach
//    void setUp(){
//        playerDto = new PlayerDto();
//        playerDto.setPlayerName("웨인루니");
//        playerDto.setPlayerEnter(250L);
//        playerDto.setPlayerTotalScore(104L);
//        playerDto.setPlayerOverall(98L);
//        playerDto.setPlayerBacknumber(7L);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Date birthdate = dateFormat.parse("1990-01-02");
//            playerDto.setPlayerBirth(birthdate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        playerDto.setPlayerContent("siu!!!!");
//        playerDto.setFameNumber(1L);
//        playerDto.setWithNumber(2L);
//        playerDto.setPositionNumber(4L);
//        playerDto.setAdminNumber(1L);
//
//        playerVo = new PlayerVo();
//        playerVo.setPlayerName("웨인루니");
//        playerVo.setPlayerEnter(250L);
//        playerVo.setPlayerTotalScore(104L);
//        playerVo.setPlayerOverall(98L);
//        playerVo.setPlayerBacknumber(7L);
//        try {
//            Date birthdate = dateFormat.parse("1990-01-02");
//            playerVo.setPlayerBirth(birthdate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        playerVo.setPlayerContent("siu!!!!");
//        playerVo.setFameNumber(1L);
//        playerVo.setWithNumber(2L);
//        playerVo.setPositionNumber(4L);
//        playerVo.setAdminNumber(1L);
//    }

    @Test
    void adminLogin() {
    }

    @Test
    @DisplayName("선수 등록")
    void register() {
        doNothing().when(adminMapper).insertPlayer(any(PlayerDto.class));

        adminService.register(playerDto);

        verify(adminMapper, times(1)).insertPlayer(playerDto);
    }

    @Test
    @DisplayName("선수 삭제")
    void removePlayer() {
        doNothing().when(adminMapper).deletePlayer(any(Long.class));

        adminService.removePlayer(1L);

        verify(adminMapper, times(1)).deletePlayer(1L);
    }

    @Test
    @DisplayName("선수 수정")
    void modifyPlayer() {
        doNothing().when(adminMapper).updatePlayer(any(PlayerDto.class));

        adminService.modifyPlayer(playerDto);

        verify(adminMapper, times(1)).updatePlayer(playerDto);
    }

    @Test
    @DisplayName("선수 조회")
    void findPlayer() {
        doReturn(playerVo).when(adminMapper).selectPlayer(any(Long.class));


        PlayerVo foundPlayer = adminService.findPlayer(1L);

        assertThat(foundPlayer).isEqualTo(playerVo.getPlayerName());
    }

    @Test
    @DisplayName("선수 전체 조회")
    void findAll() {
//        doReturn(List.of(playerVo)).when(adminMapper).selectAllPlayer();
//
//        List<PlayerVo> foundList = adminService.findAll();
//
//        assertThat(foundList).contains(playerVo);
    }
}