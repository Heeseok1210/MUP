package com.example.mup.service.museum;

import com.example.mup.mapper.museum.MuseumMapper;
import com.example.mup.vo.CriteriaAct;
import com.example.mup.vo.PlayerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MuseumService {
    private final MuseumMapper museumMapper;

//    선수 조회
    @Transactional(readOnly = true)
    public PlayerVo findPlayer(Long playerNumber){
        if(playerNumber == null){
            throw new IllegalArgumentException("선수 번호가 없습니둥");
        }
        return Optional.ofNullable(museumMapper.selectPlayer(playerNumber))
                .orElseThrow(() -> {throw new IllegalArgumentException("존재하지 않는 선수 번호입니둥!");});
    }

//    레전드 선수 조회
    @Transactional(readOnly = true)
    public List<PlayerVo> findLegend(){
        Random random = new Random();
        List<PlayerVo> legendList = new ArrayList<>();
        int number;
        Set<Integer> selectdNumbers = new HashSet<>();

        for (int i=0; i<6; i++){
            do{
                number = random.nextInt(getLegendCnt()) + 1;
            }while (!selectdNumbers.add(number));
            legendList.add(museumMapper.selectLegendPlayer(number));
        }

        return legendList;
    }
//    레전드 선수 수
    @Transactional(readOnly = true)
    public int getLegendCnt(){return museumMapper.selectLegendCnt();}

//    현역 선수 조회
    @Transactional(readOnly = true)
    public List<PlayerVo> findActive(CriteriaAct criteriaAct){
        return museumMapper.selectActivePlayer(criteriaAct);
    }

//    현역 선수 수
    @Transactional(readOnly = true)
    public int getActiveCnt(){return museumMapper.selectActiveCnt();}

//    조회 수
    public void updateReadCnt(Long playerNumber){
        if(playerNumber == null){
            throw new IllegalArgumentException("읭?");
        }
        museumMapper.updateReadCount(playerNumber);
    }
}
