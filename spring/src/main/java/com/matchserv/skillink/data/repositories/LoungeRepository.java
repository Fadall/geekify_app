package com.matchserv.skillink.data.repositories;

import com.matchserv.skillink.data.models.Lounge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoungeRepository extends JpaRepository<Lounge, Long> {
}
