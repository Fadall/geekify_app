package com.matchserv.skillink.application.impl;

import com.matchserv.skillink.application.LoungeService;
import com.matchserv.skillink.data.models.Lounge;
import com.matchserv.skillink.data.repositories.LoungeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoungeServiceImpl implements LoungeService {

    private final LoungeRepository loungeRepo;

    @Override
    public Lounge save(Lounge lounge) {
        return loungeRepo.save(lounge);
    }

    @Override
    public void delete(Lounge lounge) {
        loungeRepo.delete(lounge);
    }

    @Override
    public Lounge findById(Long id) {
        return loungeRepo.findById(id).orElse(null);
    }

    @Override
    public List<Lounge> findAll() {
        return loungeRepo.findAll();
    }
}
