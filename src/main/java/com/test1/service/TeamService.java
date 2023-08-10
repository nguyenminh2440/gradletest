package com.test1.service;

import com.test1.payload.TeamDto;

import java.util.List;

public interface TeamService {
    public TeamDto createTeam(TeamDto teamDto);
    public TeamDto getTeamById(Long id);
    public List<TeamDto> getAllTeams();

    public TeamDto updateTeam(TeamDto teamDto, Long id);

    public void deleteTeam(Long id);

}
