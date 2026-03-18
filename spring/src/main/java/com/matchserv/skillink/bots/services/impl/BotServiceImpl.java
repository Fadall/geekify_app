package com.matchserv.skillink.bots.services.impl;

import com.matchserv.skillink.bots.services.BotService;
import com.matchserv.skillink.bots.data.models.Bot;
import com.matchserv.skillink.bots.data.repositories.BotRepository;
import com.matchserv.skillink.data.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BotServiceImpl implements BotService {

    private final BotRepository botRepo;

    @Override
    public Bot save(Bot bot) {
        return botRepo.save(bot);
    }

    @Override
    public void delete(Bot bot) {
        botRepo.delete(bot);
    }

    @Override
    public Bot findById(Long id) {
        return botRepo.findById(id).orElse(null);
    }

    @Override
    public List<Bot> findAll() {
        return botRepo.findAll();
    }

    @Override
    public Bot getBotByAdminEmail(String adminEmail) {
        return botRepo.findByAdminEmail(adminEmail).orElse(null);
    }

    @Override
    public Bot getBotByAdmin(User admin) {
        return botRepo.findByAdmin(admin).orElse(null);
    }
}
