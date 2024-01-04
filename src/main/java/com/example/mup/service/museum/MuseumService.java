package com.example.mup.service.museum;

import com.example.mup.mapper.museum.MuseumMapper;
import com.example.mup.vo.Criteria;
import com.example.mup.vo.CriteriaAct;
import com.example.mup.vo.PlayerVo;
import com.example.mup.vo.SearchPlayerVo;
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

//    레전드 선수 조회
    @Transactional(readOnly = true)
    public List<PlayerVo> findLegendPlayer(Criteria criteria){return museumMapper.selectLegend(criteria);}

//    선수 검색(현역)
    public List<PlayerVo> findPlayerListByName(SearchPlayerVo searchPlayerVo, CriteriaAct criteriaAct, Long playerNumber){
        if (searchPlayerVo == null){
            throw new IllegalArgumentException("선수가 없습니둥");
        }
        return museumMapper.searchActivePlayer(searchPlayerVo, criteriaAct, playerNumber);
    }

//    선수 검색 조회
    public int findSearchTotal(SearchPlayerVo searchPlayerVo){
        if (searchPlayerVo == null){
            throw new IllegalArgumentException("searchPlayerVo 누락!");
        }
        return museumMapper.searchTotalPlayer(searchPlayerVo);
    }

//    선수 검색(레전드)
    @Transactional(readOnly = true)
    public List<PlayerVo> findLegendListByName(SearchPlayerVo searchPlayerVo, Criteria criteria, Long playerNumber){
        if (searchPlayerVo == null){
            throw new IllegalArgumentException("선수가 없다는디?");
        }
        return  museumMapper.searchLegendPlayer(searchPlayerVo, criteria, playerNumber);
    }

//    선수 검색 조회
    public int findSearchLTotal(SearchPlayerVo searchPlayerVo){
        if (searchPlayerVo == null){
            throw new IllegalArgumentException("searchPlayerVo 누락!");
        }
        return museumMapper.searchTotalLPlayer(searchPlayerVo);
    }
}
