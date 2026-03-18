package com.matchserv.skillink.application.impl;

import com.matchserv.skillink.application.ProjectService;
import com.matchserv.skillink.data.models.Project;
import com.matchserv.skillink.data.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepo;

    @Override
    public Project save(Project project) {
        return projectRepo.save(project);
    }

    @Override
    public void delete(Project project) {
        projectRepo.delete(project);
    }

    @Override
    public Project findById(Long id) {
        return projectRepo.findById(id).orElse(null);
    }

    @Override
    public List<Project> findAll() {
        return projectRepo.findAll();
    }
}
