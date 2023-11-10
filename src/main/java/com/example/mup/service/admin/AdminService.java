package com.example.mup.service.admin;

import com.example.mup.dto.admin.AdminDto;
import com.example.mup.dto.museum.PlayerDto;
import com.example.mup.mapper.admin.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminService {
    private final AdminMapper adminMapper;

//    관리자 로그인
    public long adminLogin(String adminId, String adminPassword){
        if(adminId == null || adminPassword == null){
            throw new IllegalArgumentException("아이디 또는 비밀번호 누락");
        }

        return Optional.ofNullable(adminMapper.selectAdminNumber(adminId, adminPassword))
                .orElseThrow(() -> {throw new IllegalArgumentException("일치하는 관리자 정보가 없습니다.");});
    }

//    선수 등록
    public void register(PlayerDto playerDto){
        if(playerDto == null){
            throw new IllegalArgumentException("선수 정보가 없습니다.");
        }
        System.out.println(playerDto.getPlayerNumber());
        adminMapper.insertPlayer(playerDto);
    }
}
