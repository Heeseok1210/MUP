package com.example.mup.service.maker;

import com.example.mup.mapper.maker.MakerMapper;
import com.example.mup.vo.PlayerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MakerService {
    private final MakerMapper makerMapper;

//    선수 조회
    @Transactional(readOnly = true)
    public List<PlayerVo> findAllPlayer(Long playerNumber){return makerMapper.selectAllPlayer(playerNumber);}

//    선수 전체 수 조회
    @Transactional(readOnly = true)
    public int getTotalPlayer(){return makerMapper.selectTotal();}
}
