package com.example.mup.service.main;

import com.example.mup.mapper.main.MainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainService {
    private final MainMapper mainMapper;
}
