package com.test1.repository;

import com.test1.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Player,Long> {

    @Query(value = "SELECT * FROM players WHERE team_id = :teamId",nativeQuery = true)
    public List<Player> getAllPlayersInTeam(Long teamId);

    @Query(value = "SELECT * FROM players WHERE team_id = :teamId AND id = :playerId",nativeQuery = true)
    public Player getPlayerInTeam(Long teamId,Long playerId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM players WHERE team_id = :teamId AND id = :playerId", nativeQuery = true)
    public void deletePlayer(Long teamId, Long playerId);


}
