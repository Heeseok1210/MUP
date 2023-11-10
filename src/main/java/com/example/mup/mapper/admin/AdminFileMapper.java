package com.example.mup.mapper.admin;

import com.example.mup.dto.museum.PlayerDto;
import com.example.mup.dto.museum.PlayerFileDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminFileMapper {
//    선수 파일 등록
    public void insertPlayerFile(PlayerFileDto playerFileDto);
}
