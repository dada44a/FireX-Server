package com.firex.firex.DTO;

import java.time.LocalDate;

public record ShowDTO(
        Long id,
        java.time.LocalTime showTime,
        LocalDate showDate,
        MovieSummaryDTO movie
) {
}
