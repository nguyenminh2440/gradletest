package com.test1.payload;

import com.test1.entity.Team;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private int jersey;




}
