package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.OwnerDTO;
import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exceptions.OwnerNotFoundException;
import com.tecsup.petclinic.repositories.OwnerRepository;
import com.tecsup.petclinic.util.TObjectCreator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
public class OwnerServiceTest {

    @Autowired
    private OwnerService ownerService;

    @MockitoBean
    private OwnerRepository repository;

    // =========================================================================
    // Integrante A ÔÇö Casos de error
    // =========================================================================

    /**
     * Verifica que findById lance OwnerNotFoundException cuando el ID no existe.
     */
    @Test
    public void testFindOwnerById_NotFound() {
        // Arrange
        Mockito.when(repository.findById(999))
                .thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(OwnerNotFoundException.class, () -> {
            ownerService.findById(999);
        });
    }

    /**
     * Verifica que delete lance OwnerNotFoundException cuando el ID no existe.
     */
    @Test
    public void testDeleteOwner_NotFound() {
        // Arrange
        Mockito.when(repository.existsById(999)).thenReturn(false);

        // Act & Assert
        assertThrows(OwnerNotFoundException.class, () -> {
            ownerService.delete(999);
        });
    }

    /**
     * Verifica que findByLastName retorne lista vac├¡a cuando no hay coincidencias.
     */
    @Test
    public void testFindByLastName_Empty() {
        // Arrange
        Mockito.when(repository.findByLastName("Inexistente"))
                .thenReturn(Optional.empty());

        // Act
        List<OwnerDTO> result = ownerService.findByLastName("Inexistente");

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // =========================================================================
    // Integrante B (Johan) ÔÇö B├║squedas y consultas
    // =========================================================================

    /**
     * Verifica que findById devuelva el Owner correcto cuando existe.
     */
    @Test
    public void testFindOwnerById() {
        // Arrange
        Owner ownerExpected = TObjectCreator.getOwner();
        Mockito.when(repository.findById(1))
                .thenReturn(Optional.of(ownerExpected));

        // Act
        OwnerDTO owner;
        try {
            owner = ownerService.findById(1);
        } catch (OwnerNotFoundException e) {
            fail(e.getMessage());
            return;
        }

        // Assert
        log.info("Expected: " + ownerExpected);
        log.info("Returned: " + owner);
        assertEquals(ownerExpected.getId().intValue(), owner.getId());
        assertEquals(ownerExpected.getFirstName(), owner.getFirstName());
        assertEquals(ownerExpected.getLastName(), owner.getLastName());
    }

    /**
     * Verifica que findByLastName devuelva los Owners con el apellido indicado.
     */
    @Test
    public void testFindByLastName() {
        // Arrange
        String FIND_LAST_NAME = "Davis";
        List<Owner> ownersExpected = TObjectCreator.getOwnersForFindByLastName();
        Mockito.when(repository.findByLastName(FIND_LAST_NAME))
                .thenReturn(ownersExpected);

        // Act
        List<OwnerDTO> owners = ownerService.findByLastName(FIND_LAST_NAME);

        // Assert
        assertEquals(ownersExpected.size(), owners.size());
        owners.forEach(owner -> assertEquals(FIND_LAST_NAME, owner.getLastName()));
    }

    /**
     * Verifica que findByCity devuelva los Owners de la ciudad indicada.
     */
    @Test
    public void testFindByCity() {
        // Arrange
        String FIND_CITY = "Madison";
        List<Owner> ownersExpected = TObjectCreator.getOwnersForFindByCity();
        Mockito.when(repository.findByCity(FIND_CITY))
                .thenReturn(ownersExpected);

        // Act
        List<OwnerDTO> owners = ownerService.findByCity(FIND_CITY);

        // Assert
        assertEquals(ownersExpected.size(), owners.size());
        owners.forEach(owner -> assertEquals(FIND_CITY, owner.getCity()));
    }
}
