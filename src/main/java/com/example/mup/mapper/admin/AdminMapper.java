package com.example.mup.mapper.admin;

import com.example.mup.dto.admin.AdminDto;
import com.example.mup.dto.museum.PlayerDto;
import com.example.mup.vo.Criteria;
import com.example.mup.vo.PlayerVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper {
//    관리자 로그인
    public long selectAdminNumber(@Param("adminId")String adminId, @Param("adminPassword")String adminPassword);

//    선수 등록
    public void insertPlayer(PlayerDto playerDto);

//    선수 삭제
    public void deletePlayer(Long playerNumber);
//    선수 수정
    public void updatePlayer(PlayerDto playerDto);
//    선수 조회
    public PlayerVo selectPlayer(Long playerNumber);
//    선수 전체 조회
    public List<PlayerVo> selectAllPlayer(Criteria criteria);
//    선수 전체 수 조회
    public int selectTotal();
}
