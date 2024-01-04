package com.example.mup.dto.maker;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;


@Component
@Data
@NoArgsConstructor
public class SquadDto {
    private Long squadNumber;
    private String squadTitle;
    private List<String> squadList;
    private Long formationNumber;
    private Long consumerNumber;
}
