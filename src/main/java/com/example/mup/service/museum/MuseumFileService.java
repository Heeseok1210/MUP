package com.example.mup.service.museum;

import com.example.mup.dto.museum.PlayerFileDto;
import com.example.mup.mapper.museum.MuseumFileMapper;
import com.example.mup.mapper.museum.MuseumMapper;
import com.example.mup.vo.PlayerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MuseumFileService {
    private final MuseumFileMapper museumFileMapper;

//    선수 이미지 조회
    public List<PlayerFileDto> findList(Long playerNumber){return museumFileMapper.selectList(playerNumber);}
}
