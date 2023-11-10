package com.example.mup.mapper.admin;

import com.example.mup.dto.admin.AdminDto;
import com.example.mup.dto.museum.PlayerDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {
//    관리자 로그인
    public long selectAdminNumber(@Param("adminId")String adminId, @Param("adminPassword")String adminPassword);

//    선수 등록
    public void insertPlayer(PlayerDto playerDto);

}
