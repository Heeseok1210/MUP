package com.example.mup.dto.museum;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;


@Component
@Data
@NoArgsConstructor
public class PlayerDto {
    private Long playerNumber;
    private String playerName;
    private Long playerEnter;
    private Long playerTotalScore;
    private Long playerOverall;
    private Long playerBacknumber;
    private Date playerBirth;
    private String playerContent;
    private Long fameNumber;
    private Long withNumber;
    private Long positionNumber;
}
