package com.matchserv.skillink.bots.services;

import com.matchserv.skillink.application.BaseService;
import com.matchserv.skillink.bots.data.models.Bot;
import com.matchserv.skillink.data.models.User;
import org.springframework.stereotype.Service;

@Service
public interface BotService extends BaseService<Bot> {

    Bot getBotByAdminEmail(String adminEmail);

    Bot getBotByAdmin(User admin);

}
