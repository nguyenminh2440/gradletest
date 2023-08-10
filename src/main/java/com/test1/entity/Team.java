package com.test1.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "color")
    private String color;

    @Getter
    @OneToMany(mappedBy = "team",cascade = CascadeType.ALL)
    private Set<Player> players;

}
