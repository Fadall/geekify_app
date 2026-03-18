package com.matchserv.skillink.api.mappers;

import com.matchserv.skillink.api.dto.ProjectDto;
import com.matchserv.skillink.data.models.Project;
import com.matchserv.skillink.data.models.User;

import java.util.stream.Collectors;

public class ProjectMapper {

    public static ProjectDto toDto(Project project) {
        ProjectDto dto = new ProjectDto();
        dto.setId(project.getId());
        dto.setTitle(project.getTitle());
        dto.setDescription(project.getDescription());
        dto.setOwnerId(project.getOwner() != null ? project.getOwner().getId() : null);
        dto.setCategoryId(project.getCategory() != null ? project.getCategory().getId() : null);

        dto.setParticipantIds(project.getParticipants() != null ?
                project.getParticipants().stream().map(User::getId).collect(Collectors.toList()) : null);

        return dto;
    }

    public static Project toEntity(ProjectDto projectDto) {
        Project project = new Project();
        project.setId(projectDto.getId());
        project.setTitle(projectDto.getTitle());
        project.setDescription(projectDto.getDescription());
        return project;
    }
}
