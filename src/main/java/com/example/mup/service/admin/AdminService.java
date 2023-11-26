package com.example.mup.service.admin;

import com.example.mup.dto.admin.AdminDto;
import com.example.mup.dto.museum.PlayerDto;
import com.example.mup.mapper.admin.AdminMapper;
import com.example.mup.vo.Criteria;
import com.example.mup.vo.PlayerVo;
import com.example.mup.vo.SearchPlayerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminService {
    private final AdminMapper adminMapper;
    private final AdminFileService adminFileService;

//    관리자 로그인
    @Transactional(readOnly = true)
    public long adminLogin(String adminId, String adminPassword){
        if(adminId == null || adminPassword == null){
            throw new IllegalArgumentException("아이디 또는 비밀번호 누락");
        }

        return Optional.ofNullable(adminMapper.selectAdminNumber(adminId, adminPassword))
                .orElseThrow(() -> {throw new IllegalArgumentException("일치하는 관리자 정보가 없습니다.");});
    }

//    선수 등록
    public void register(PlayerDto playerDto){
        if(playerDto == null){
            throw new IllegalArgumentException("선수 정보가 없습니다.");
        }
        System.out.println(playerDto.getPlayerNumber());
        adminMapper.insertPlayer(playerDto);
        System.out.println("playerDto = " + playerDto);
    }

//    선수 삭제
    public void removePlayer(Long playerNumber){
        if(playerNumber == null){
            throw new IllegalArgumentException("존재하지 않는 선수");
        }
        adminMapper.deletePlayer(playerNumber);
    }
//    선수 수정
    public void modifyPlayer(PlayerDto playerDto){
        if (playerDto == null){
            throw new IllegalArgumentException("선수 수정 정보가 없습니듕");
        }
        adminMapper.updatePlayer(playerDto);
    }

    public void modifyPlayer(PlayerDto playerDto, List<MultipartFile> files) throws IOException{
        if (playerDto == null || files == null){
            throw new IllegalArgumentException("선수 수정 매개변수 null 체크");
        }
        adminFileService.remove(playerDto.getPlayerNumber());
        adminFileService.registerAndSaveFiles(files, playerDto.getPlayerNumber());
        adminMapper.updatePlayer(playerDto);
    }

//    선수 조회
    /**
     *
     * @param playerNumber
     * @return
     * @throws IllegalArgumentException 선수 번호가 존재하지 않으면 발생된다.
     */
    @Transactional(readOnly = true)
    public PlayerVo findPlayer(Long playerNumber){
        if (playerNumber == null){
            throw new IllegalArgumentException("선수 번호가 없습니둥");
        }
        return Optional.ofNullable(adminMapper.selectPlayer(playerNumber))
                .orElseThrow(() -> {throw new IllegalArgumentException("존재하지 않는 선수 번호");});
    }
//    선수 전체 조회
    @Transactional(readOnly = true)
    public List<PlayerVo> findAll(Criteria criteria){
        return adminMapper.selectAllPlayer(criteria);
    }

//    선수 전체 수 조회
    @Transactional(readOnly = true)
    public int getTotalPlayer(){
        return adminMapper.selectTotal();
    }

//    선수 검색
    @Transactional(readOnly = true)
    public List<PlayerVo> findAllListByName(SearchPlayerVo searchPlayerVo, Criteria criteria, Long playerNumber){
        if (searchPlayerVo == null){
            throw new IllegalArgumentException("선수가 없다는디?");
        }
        return adminMapper.searchAllPlayer(searchPlayerVo, criteria, playerNumber);
    }

//    선수 검색 수 조회
    public int findSearchTotal(SearchPlayerVo searchPlayerVo){
        if (searchPlayerVo == null){
            throw new IllegalArgumentException("searchPlayerVo 누락!");
        }
        return adminMapper.searchTotalPlayer(searchPlayerVo);
    }
}
