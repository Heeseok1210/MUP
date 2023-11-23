package com.example.mup.mapper.main;

import com.example.mup.vo.PlayerVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainMapper {
//    레전드 선수 띄우기
    public PlayerVo selectLegendPlayer(int number);
//    레전드 선수 수
    public int selectLegendCnt();
}
