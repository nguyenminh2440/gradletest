package com.test1.service;

import com.test1.payload.PlayerDto;

import java.util.List;

public interface PlayerService {
    public PlayerDto createPlayer(PlayerDto playerDto,Long teamId);

    public PlayerDto getPlayerById(Long teamId, Long playerId);

    public List<PlayerDto> getAllPlayersInTeam(Long teamId);

    public PlayerDto updatePlayer(PlayerDto playerDto,Long teamId,Long playerId);

    public void deletePlayer(Long teamId, Long playerId);
}
