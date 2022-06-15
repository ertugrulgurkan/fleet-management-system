package com.ertugrul.fleet.management.system.validation;

import com.ertugrul.fleet.management.system.entity.Pack;
import com.ertugrul.fleet.management.system.exception.NotFoundException;
import com.ertugrul.fleet.management.system.util.ObjectFactoryTest;
import com.ertugrul.fleet.management.system.exception.AlreadyExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EntityValidationServiceTest {

    EntityValidationService<Pack> packEntityValidationService;

    @BeforeEach
    void setUp() {
        packEntityValidationService = new EntityValidationService<>();
    }

    @Test
    void shouldValidateEntity() {
        Optional<Pack> expectedOptional = ObjectFactoryTest.getOptionalPack();
        Pack expected = expectedOptional.get();
        Pack actual = packEntityValidationService.validateEntity(expectedOptional, "Pack");
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual)
        );
    }

    @Test
    void shouldNotValidateEntity() {
        Optional<Pack> expectedOptional = ObjectFactoryTest.getOptionalEmpty();
        assertThrows(NotFoundException.class, () -> packEntityValidationService.validateEntity(expectedOptional, "Pack"));
    }

    @Test
    void isEmpty() {
        Optional<Pack> expectedOptional = ObjectFactoryTest.getOptionalEmpty();
        assertTrue(packEntityValidationService.isEmpty(expectedOptional, "Pack"));
    }

    @Test
    void isNotEmpty() {
        Optional<Pack> expectedOptional = ObjectFactoryTest.getOptionalPack();
        assertThrows(AlreadyExistException.class, () -> packEntityValidationService.isEmpty(expectedOptional, "Pack"));
    }
}