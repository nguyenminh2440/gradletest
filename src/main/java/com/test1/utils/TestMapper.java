package com.test1.utils;

import com.test1.entity.Player;
import com.test1.entity.Team;
import com.test1.payload.PlayerDto;
import com.test1.payload.TeamDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TestMapper {
    TestMapper INSTANCE = Mappers.getMapper(TestMapper.class);
    TeamDto convert(Team team);
    Team convert(TeamDto teamDto);

    Player convert(PlayerDto playerDto);

    PlayerDto convert(Player player);
}