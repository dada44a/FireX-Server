package com.firex.firex.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShowDTO {
    private Long id;
    private Long movieId;
    private LocalTime showTime;
    private LocalDate showDate;
    private String adminEmail;
    private Long screenId;

}

