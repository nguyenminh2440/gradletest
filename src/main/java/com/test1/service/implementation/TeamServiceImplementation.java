package com.test1.service.implementation;

import com.test1.entity.Team;
import com.test1.payload.TeamDto;
import com.test1.repository.PlayerRepository;
import com.test1.repository.TeamRepository;
import com.test1.service.TeamService;
import com.test1.utils.TestMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImplementation implements TeamService {

    TeamRepository teamRepository;
    PlayerRepository playerRepository;

    public TeamServiceImplementation(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public TeamDto createTeam(TeamDto teamDto) {
        Team team = mapToEntity(teamDto);

        Team savedTeam = teamRepository.save(team);

        return mapToDto(savedTeam);

    }




    @Override
    public TeamDto getTeamById(Long id) {
        Team team = teamRepository.getTeamById(id);
        return mapToDto(team);


    }

    @Override
    public List<TeamDto> getAllTeams() {
        //return teamRepository.getAllTeams().stream().map(this::mapToDto).collect(Collectors.toList());
        List<Team> teams = teamRepository.getAllTeams();
        return teams.stream().map(this::mapToDto).collect(Collectors.toList());

    }

    @Override
    public TeamDto updateTeam(TeamDto teamDto, Long id) {
        Team team = teamRepository.getTeamById(id);
        team.setName(teamDto.getName());
        team.setColor(teamDto.getColor());
        teamRepository.save(team);
        return mapToDto(team);
    }

    @Override
    public void deleteTeam(Long id) {
        teamRepository.deleteTeam(id);

    }

    private TeamDto mapToDto(Team team) {
        return TestMapper.INSTANCE.convert(team);
    }

    private Team mapToEntity(TeamDto teamDto) {
        return TestMapper.INSTANCE.convert(teamDto);
    }


}
