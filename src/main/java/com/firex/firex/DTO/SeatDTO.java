package com.firex.firex.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SeatDTO {
    private String row;
    private int column;
    private Long screenId; // FK to the screen
}
