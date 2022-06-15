package com.ertugrul.fleet.management.system.service.entityservice.impl;

import com.ertugrul.fleet.management.system.entity.BaseEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public abstract class BaseEntityService<E extends BaseEntity, R extends JpaRepository> {
    private R repository;

    public List<E> findAll() {
        return repository.findAll();
    }

    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    public E save(E e) {
        return (E) repository.save(e);
    }

    public E create(E e) {
        return (E) repository.save(e);
    }

    public void delete(E e) {
        repository.delete(e);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public R getRepository() {
        return repository;
    }
}