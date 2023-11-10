package com.example.mup.dto.museum;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;


@Component
@Data
@NoArgsConstructor
public class PlayerFileDto {
    private Long playerFileNumber;
    private String playerFileName;
    private String playerFileUploadPath;
    private String playerFileUuid;
    private Long playerNumber;

}
