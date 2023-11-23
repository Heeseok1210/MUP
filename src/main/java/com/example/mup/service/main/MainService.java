package com.example.mup.service.main;

import com.example.mup.mapper.main.MainMapper;
import com.example.mup.vo.PlayerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MainService {
    private final MainMapper mainMapper;

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
            legendList.add(mainMapper.selectLegendPlayer(number));
        }

        return legendList;
    }

//    레전드 선수 수
    @Transactional(readOnly = true)
    public int getLegendCnt(){return mainMapper.selectLegendCnt();}
}
