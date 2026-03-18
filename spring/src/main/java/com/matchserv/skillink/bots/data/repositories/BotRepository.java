package com.matchserv.skillink.bots.data.repositories;

import com.matchserv.skillink.bots.data.models.Bot;
import com.matchserv.skillink.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BotRepository extends JpaRepository<Bot, Long> {

    Optional<Bot> findByAdminEmail(String adminEmail);

    Optional<Bot> findByAdmin(User admin);

}
