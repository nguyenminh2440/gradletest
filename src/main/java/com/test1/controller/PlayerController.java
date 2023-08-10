package com.test1.controller;

import com.test1.payload.PlayerDto;
import com.test1.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/teams/")
public class PlayerController {
    PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/{teamId}/players")
    public ResponseEntity<PlayerDto> createPlayer(@PathVariable(name = "teamId") Long teamId,@RequestBody PlayerDto playerDto) {
        return new ResponseEntity<>(playerService.createPlayer(playerDto,teamId), HttpStatus.CREATED);
    }

    @GetMapping("/{teamId}/players/{playerId}")
    public ResponseEntity<PlayerDto> getPlayerInTeam(@PathVariable(name = "teamId") Long teamId,@PathVariable(name = "playerId") Long playerId) {
        return new ResponseEntity<>(playerService.getPlayerById(teamId,playerId),HttpStatus.OK);
    }

    @GetMapping("/{teamId}/players")
    public ResponseEntity<List<PlayerDto>> getAllPlayersInTeam(@PathVariable(name = "teamId") Long teamId) {
        return new ResponseEntity<>(playerService.getAllPlayersInTeam(teamId),HttpStatus.OK);

    }

    @PutMapping("/{teamId}/players/{playerId}")
    public ResponseEntity<PlayerDto> updatePlayer(@PathVariable(name = "teamId") Long teamId,@PathVariable(name = "playerId") Long playerId,@RequestBody PlayerDto playerDto) {
        return new ResponseEntity<>(playerService.updatePlayer(playerDto,teamId,playerId),HttpStatus.OK);

    }


    @DeleteMapping("/{teamId}/players/{playerId}")
    public ResponseEntity<String> deletePlayer(@PathVariable(name = "teamId") Long teamId, @PathVariable(name = "playerId") Long playerId) {
        playerService.deletePlayer(teamId,playerId);
        return new ResponseEntity<>("Player has been deleted",HttpStatus.OK);
    }





}
