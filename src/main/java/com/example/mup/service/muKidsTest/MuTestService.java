package com.example.mup.service.muKidsTest;

import com.example.mup.mapper.maker.MakerMapper;
import com.example.mup.mapper.muKidsTest.MuTestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MuTestService {
    private final MuTestMapper muTestMapper;
}
