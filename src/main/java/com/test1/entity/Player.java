package com.test1.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Table(name="players")
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class Player {
    //comment

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fname",nullable = false)
    private String firstName;

    @Column(name = "lname",nullable = false)
    private String lastName;

    @Column(name = "jersey", nullable = false)
    private int jersey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id",nullable = false)
    private Team team;

    public void setTeam(Team team) {
        this.team = team;
    }


}
