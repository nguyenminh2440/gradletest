package com.test1.repository;

import com.test1.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface TeamRepository extends JpaRepository<Team,Long> {

    @Query(value = "SELECT * FROM teams",nativeQuery = true)
    public List<Team> getAllTeams();

    @Query(value = "SELECT * FROM teams WHERE id = :teamId",nativeQuery = true)
    public Team getTeamById(Long teamId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM teams WHERE id= :teamId ",nativeQuery = true)
    public void deleteTeam(Long teamId);


}
