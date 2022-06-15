package com.ertugrul.fleet.management.system.validation;

import com.ertugrul.fleet.management.system.exception.NotFoundException;
import com.ertugrul.fleet.management.system.exception.AlreadyExistException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntityValidationService<T> implements Validator<T> {
    @Override
    public T validateEntity(Optional<T> entity, String name) {
        return entity.orElseThrow(() -> new NotFoundException(name + " entity is not found"));
    }

    @Override
    public boolean isEmpty(Optional<T> entity, String name) {
        if (entity.isPresent())
            throw new AlreadyExistException(name + " is already exist.");
        return true;
    }

}
