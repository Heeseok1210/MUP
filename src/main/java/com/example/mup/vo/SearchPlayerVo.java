package com.example.mup.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@Data
@NoArgsConstructor
public class SearchPlayerVo {
    private Long playerNumber;
    private String playerName;
    private String keyword;
    private String positionName;

}
