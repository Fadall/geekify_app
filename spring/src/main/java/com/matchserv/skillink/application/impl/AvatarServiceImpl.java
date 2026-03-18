package com.matchserv.skillink.application.impl;

import com.matchserv.skillink.application.AvatarService;
import com.matchserv.skillink.data.models.Avatar;
import com.matchserv.skillink.data.repositories.AvatarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvatarServiceImpl implements AvatarService {

    private final AvatarRepository avatarRepo;

    @Override
    public Avatar save(Avatar avatar) {
        return avatarRepo.save(avatar);
    }

    @Override
    public void delete(Avatar avatar) {
        avatarRepo.delete(avatar);
    }

    @Override
    public Avatar findById(Long id) {
        return avatarRepo.findById(id).orElse(null);
    }

    @Override
    public List<Avatar> findAll() {
        return avatarRepo.findAll();
    }
}
