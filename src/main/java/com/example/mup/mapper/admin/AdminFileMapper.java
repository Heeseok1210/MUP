package com.example.mup.mapper.admin;

import com.example.mup.dto.museum.PlayerDto;
import com.example.mup.dto.museum.PlayerFileDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminFileMapper {
//    선수 파일 등록
    public void insertPlayerFile(PlayerFileDto playerFileDto);
//    선수 파일 삭제
    public void deletePlayerFile(Long playerNumber);
//    선수 파일 조회
    public List<PlayerFileDto> selectList(Long playerNumber);
}
