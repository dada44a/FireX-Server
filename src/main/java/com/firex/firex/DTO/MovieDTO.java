package com.firex.firex.DTO;

import java.time.LocalDate;

public record MovieDTO(
        Long id,
        String title,
        String description,
        LocalDate releaseDate
){}
