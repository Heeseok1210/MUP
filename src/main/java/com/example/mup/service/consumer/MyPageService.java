package com.example.mup.service.consumer;

import com.example.mup.mapper.consumer.MyPageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MyPageService {
    private final MyPageMapper myPageMapper;
}
