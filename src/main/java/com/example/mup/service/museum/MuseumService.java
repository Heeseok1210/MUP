package com.example.mup.service.museum;

import com.example.mup.mapper.museum.MuseumMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MuseumService {
    private final MuseumMapper museumMapper;
}
