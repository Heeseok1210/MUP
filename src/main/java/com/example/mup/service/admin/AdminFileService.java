package com.example.mup.service.admin;

import com.example.mup.dto.museum.PlayerDto;
import com.example.mup.dto.museum.PlayerFileDto;
import com.example.mup.mapper.admin.AdminFileMapper;
import com.example.mup.mapper.admin.AdminMapper;
import lombok.RequiredArgsConstructor;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminFileService {
    private final AdminFileMapper adminFileMapper;

    @Value("${file.dir}")
    private String fileDir;

    public void register(PlayerFileDto playerFileDto) {
        if (playerFileDto == null) {throw new IllegalArgumentException("파일 정보 없어용~!!!");}
        adminFileMapper.insertPlayerFile(playerFileDto);
    }

    public void remove(Long playerNumber) {
        if (playerNumber == null) {
            throw new IllegalArgumentException("선수 번호 누락(file)");
        }
        adminFileMapper.deletePlayerFile(playerNumber);
    }


    public List<PlayerFileDto> findList(Long playerNumber){
        return adminFileMapper.selectList(playerNumber);
    }

//    파일 저장
    public PlayerFileDto saveFile(MultipartFile file) throws IOException{
        String originName = file.getOriginalFilename();
        UUID uuid = UUID.randomUUID();
        String sysName = uuid.toString() + "_" + originName;

        File uploadPath = new File(fileDir, getUploadPath());

//        폴더가 없는 경우!
        if(!uploadPath.exists()){
//        경로에 필요한 폴더 생성
            uploadPath.mkdirs();
        }

        File uploadFile = new File(uploadPath, sysName);

        file.transferTo(uploadFile);

//        썸네일 저장처리
//        이미지 파일인 경우에만 처리하는 조건식
        if (Files.probeContentType(uploadFile.toPath()).startsWith("image")){
            FileOutputStream out = new FileOutputStream(new File(uploadPath, "th_" + sysName));
            Thumbnailator.createThumbnail(file.getInputStream(), out, 300, 250);
            out.close();
        }

        PlayerFileDto playerFileDto = new PlayerFileDto();
        playerFileDto.setPlayerFileUuid(uuid.toString());
        playerFileDto.setPlayerFileName(originName);
        playerFileDto.setPlayerFileUploadPath(getUploadPath());


        return playerFileDto;
    }

    /**
     * 파일 리스트를 DB등록 및 저장 처리
     * @param files 여러 파일을 담은 리스트
     * @param playerNumber 파일이 속하는 선수 번호
     * @throws IOException
     */
    public void registerAndSaveFiles(List<MultipartFile> files, Long playerNumber)throws IOException{
        for (MultipartFile file : files){
            PlayerFileDto playerFileDto = saveFile(file);
            playerFileDto.setPlayerNumber(playerNumber);
            register(playerFileDto);
        }
    }

    private String getUploadPath(){
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }

}
