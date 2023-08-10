package com.test1.service.implementation;

import com.test1.entity.Player;
import com.test1.entity.Team;
import com.test1.payload.PlayerDto;
import com.test1.repository.PlayerRepository;
import com.test1.repository.TeamRepository;
import com.test1.service.PlayerService;
import com.test1.utils.TestMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImplementation implements PlayerService {

    PlayerRepository playerRepository;
    TeamRepository teamRepository;

    public PlayerServiceImplementation(PlayerRepository playerRepository,TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public PlayerDto createPlayer(PlayerDto playerDto, Long teamId) {

        Player player = mapToEntity(playerDto);
        Team team = teamRepository.getTeamById(teamId);
        player.setTeam(team);
        playerRepository.save(player);
        return maptoDto(player);


    }


    @Override
    public PlayerDto getPlayerById(Long teamId, Long playerId) {
        Player player = playerRepository.getPlayerInTeam(teamId, playerId);
        return maptoDto(player);
    }

    @Override
    public List<PlayerDto> getAllPlayersInTeam(Long teamId) {
        return playerRepository.getAllPlayersInTeam(teamId).stream().map(this::maptoDto).collect(Collectors.toList());
    }

    @Override
    public PlayerDto updatePlayer(PlayerDto playerDto, Long teamId, Long playerId) {
        Player player = playerRepository.getPlayerInTeam(teamId,playerId);
        player.setFirstName(playerDto.getFirstName());
        player.setLastName(player.getLastName());
        player.setJersey(player.getJersey());
        playerRepository.save(player);
        return maptoDto(player);
    }

    @Override
    public void deletePlayer(Long teamId, Long playerId) {
        playerRepository.deletePlayer(teamId,playerId);
    }

    private PlayerDto maptoDto(Player player) {
        return TestMapper.INSTANCE.convert(player);
    }

    private Player mapToEntity(PlayerDto playerDto) {
        return TestMapper.INSTANCE.convert(playerDto);
    }
}
