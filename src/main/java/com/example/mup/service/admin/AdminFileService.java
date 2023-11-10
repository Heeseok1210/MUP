package com.example.mup.service.admin;

import com.example.mup.dto.museum.PlayerDto;
import com.example.mup.dto.museum.PlayerFileDto;
import com.example.mup.mapper.admin.AdminFileMapper;
import com.example.mup.mapper.admin.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminFileService {
    private final AdminFileMapper adminFileMapper;

    @Value("${file.dir}")
    private String fileDir;

    public void register(PlayerFileDto playerFileDto) {
        if (playerFileDto == null) {throw new IllegalArgumentException("파일 정보 없어용~!!!");}
        adminFileMapper.insertPlayerFile(playerFileDto);
    }
}
