package com.example.mup.mapper.museum;

import com.example.mup.dto.museum.PlayerFileDto;
import com.example.mup.vo.PlayerVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MuseumFileMapper {
//    선수 조회
    public List<PlayerFileDto> selectList(Long playerNumber);
}
