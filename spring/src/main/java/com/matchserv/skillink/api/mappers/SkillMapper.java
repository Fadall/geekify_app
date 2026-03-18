package com.matchserv.skillink.api.mappers;

import com.matchserv.skillink.api.dto.SkillDto;
import com.matchserv.skillink.data.models.Project;
import com.matchserv.skillink.data.models.Skill;
import com.matchserv.skillink.data.models.User;

import java.util.stream.Collectors;

public class SkillMapper {

    public static SkillDto toDto(Skill skill) {
        SkillDto dto = new SkillDto();
        dto.setId(skill.getId());
        dto.setName(skill.getName());
        dto.setCategory(skill.getCategory());

        dto.setUserIds(skill.getUsers() != null ?
                skill.getUsers().stream().map(User::getId).collect(Collectors.toList()) : null );

        dto.setProjectIds(skill.getProjects() != null ?
                skill.getProjects().stream().map(Project::getId).collect(Collectors.toList()) : null);
        return dto;
    }

    public static Skill toEntity(SkillDto dto) {
        Skill skill = new Skill();
        skill.setId(dto.getId());
        skill.setName(dto.getName());
        skill.setCategory(dto.getCategory());
        return skill;
    }
}
