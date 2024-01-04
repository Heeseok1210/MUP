package com.example.mup.mapper.museum;

import com.example.mup.vo.Criteria;
import com.example.mup.vo.CriteriaAct;
import com.example.mup.vo.PlayerVo;
import com.example.mup.vo.SearchPlayerVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MuseumMapper {
//    선수 조회
    public PlayerVo selectPlayer(Long playerNumber);
//    레전드 선수 띄우기
    public PlayerVo selectLegendPlayer(int number);
//    레전드 선수 수
    public int selectLegendCnt();
//    현역 선수 띄우기
    public List<PlayerVo> selectActivePlayer(CriteriaAct criteriaAct);
//    현역 선수 수
    public int selectActiveCnt();
//    레전드 선수 띄우기
    public List<PlayerVo> selectLegend(Criteria criteria);
//    조회 수 업데이트
    public void updateReadCount(Long playerNumber);
//    선수 이름으로 선수 검색
    public List<PlayerVo> searchActivePlayer(@Param("searchPlayerVo")SearchPlayerVo searchPlayerVo, @Param("criteriaAct") CriteriaAct criteriaAct, @Param("playerNumber")Long playerNumber);
//    선수 검색 수(현역)
    public int searchTotalPlayer(SearchPlayerVo searchPlayerVo);
//    카테고리 및 선수 이름으로 선수 검색
    public List<PlayerVo> searchLegendPlayer(@Param("searchPlayerVo") SearchPlayerVo searchPlayerVo, @Param("criteria") Criteria criteria, @Param("playerNumber")Long playerNumber);
//    선수 검색 수(레전드)
    public int searchTotalLPlayer(SearchPlayerVo searchPlayerVo);

}
