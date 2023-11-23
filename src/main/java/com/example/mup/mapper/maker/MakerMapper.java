package com.example.mup.mapper.maker;

import com.example.mup.vo.Criteria;
import com.example.mup.vo.PlayerVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface MakerMapper {
//   선수 전체 조회
    public List<PlayerVo> selectAllPlayer(Long playerNumber);
//   선수 전체 수 조회
    public int selectTotal();
}
