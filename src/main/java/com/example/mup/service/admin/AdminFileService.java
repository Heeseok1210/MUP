package com.example.mup.service.admin;

import com.example.mup.dto.museum.PlayerDto;
import com.example.mup.dto.museum.PlayerFileDto;
import com.example.mup.mapper.admin.AdminFileMapper;
import com.example.mup.mapper.admin.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

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

////    파일 저장
//    public PlayerFileDto savePlayerFile(MultipartFile file) throws IOException{
//        String originName = file.getOriginalFilename();
//        UUID uuid = UUID.randomUUID();
//        String sysName = uuid.toString() + "_" + originName;
//
//        File uploadPath = new File(fileDir, getUploadPath());
//    }
}
