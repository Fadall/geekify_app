package com.matchserv.skillink.application.impl;

import com.matchserv.skillink.application.SkillService;
import com.matchserv.skillink.data.models.Skill;
import com.matchserv.skillink.data.repositories.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepo;

    @Override
    public Skill save(Skill skill) {
        return skillRepo.save(skill);
    }

    @Override
    public void delete(Skill skill) {
        skillRepo.delete(skill);
    }

    @Override
    public Skill findById(Long id) {
        return skillRepo.findById(id).orElse(null);
    }

    @Override
    public List<Skill> findAll() {
        return skillRepo.findAll();
    }
}
