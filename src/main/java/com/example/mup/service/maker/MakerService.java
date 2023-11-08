package com.example.mup.service.maker;

import com.example.mup.mapper.maker.MakerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MakerService {
    private final MakerMapper makerMapper;
}
