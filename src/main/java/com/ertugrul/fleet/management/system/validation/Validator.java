package com.ertugrul.fleet.management.system.validation;

import java.util.Optional;

public interface Validator<T> {
    T validateEntity(Optional<T> entity, String name);

    boolean isEmpty(Optional<T> entity, String name);
}
