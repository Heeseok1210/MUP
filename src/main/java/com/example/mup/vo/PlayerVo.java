package com.example.mup.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class PlayerVo {
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
    private Long adminNumber;
    private String adminId;
    private String fameName;
    private String withName;
    private String positionName;
}
