package com.example.mup.controller.museum;

import com.example.mup.dto.museum.PlayerFileDto;
import com.example.mup.service.museum.MuseumFileService;
import com.example.mup.service.museum.MuseumService;
import com.example.mup.vo.PlayerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/museumFile/*")
public class MuseumFileController {
    private final MuseumFileService museumFileService;

    @Value("${file.dir}")
    private String fileDir;

    @GetMapping("/imgList")
    public List<PlayerFileDto> imgList(Long playerNumber){return museumFileService.findList(playerNumber);}

    //    서버 컴퓨터에 저장된 파일을 복사하여 넘겨주는 핸들러
    @GetMapping("/display")
    public byte[] display(String fileName) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(fileDir, fileName));
    }

}
