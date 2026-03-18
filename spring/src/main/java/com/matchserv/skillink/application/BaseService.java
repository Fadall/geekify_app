package com.matchserv.skillink.application;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseService<T> {

    T save(T t);

    void delete(T t);

    T findById(Long id);

    List<T> findAll();
}
