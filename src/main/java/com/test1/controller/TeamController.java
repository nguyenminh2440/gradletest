package com.test1.controller;


import com.test1.payload.TeamDto;
import com.test1.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public ResponseEntity<TeamDto> createTeam(@RequestBody TeamDto teamDto) {
        return new ResponseEntity<>(teamService.createTeam(teamDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDto> getTeamById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(teamService.getTeamById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TeamDto>> getAllTeams() {
        return new ResponseEntity<>(teamService.getAllTeams(),HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<TeamDto> updateTeam(@PathVariable(name = "id") Long id,@RequestBody TeamDto teamDto) {
        return new ResponseEntity<>(teamService.updateTeam(teamDto,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeam(@PathVariable(name = "id") Long id) {
        teamService.deleteTeam(id);
        return new ResponseEntity<>("Team has been deleted",HttpStatus.OK);
    }


}
