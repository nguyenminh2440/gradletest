package com.test1.payload;


import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {
    private Long id;
    private String name;
    private String color;
    private Set<PlayerDto> players;


}
