package com.example.mup.controller.admin;

import com.example.mup.service.admin.AdminService;
import com.example.mup.vo.PlayerVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AdminController.class)
class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AdminService adminService;
    private PlayerVo playerVo;

    @BeforeEach
    void setUp(){
        playerVo = new PlayerVo();
        playerVo.setAdminId("aaa");
        playerVo.setPlayerName("호날두");
        playerVo.setPlayerEnter(250L);
        playerVo.setPlayerTotalScore(104L);
        playerVo.setPlayerOverall(98L);
        playerVo.setPlayerBacknumber(7L);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date birthdate = dateFormat.parse("1990-01-02");
            playerVo.setPlayerBirth(birthdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        playerVo.setPlayerContent("siu!!!!");
        playerVo.setFameNumber(1L);
        playerVo.setWithNumber(2L);
        playerVo.setPositionNumber(4L);
        playerVo.setAdminNumber(1L);
    }

    @Test
    void adminLogin() {
    }

    @Test
    void testAdminLogin() {
    }

    @Test
    void showPlayerList() throws Exception{
//        doReturn(List.of(playerVo)).when(adminService).findAll();
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/admin/list"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//
//        verify(adminService, times(1)).findAll();
    }

    @Test
    void playerWrite() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/write")
                .sessionAttr("adminNumber", 1L)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void playerRead() {
    }
}