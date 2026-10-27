package com.tecsup.petclinic.services;

<<<<<<< HEAD
import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerServiceTest {

    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    private OwnerService ownerService;

    // === Integrante A — CRUD Básico ===

    @Test
    void testCreateOwner() {
        // Arrange
        Owner newOwner = new Owner();
        newOwner.setFirstName("Juan");
        newOwner.setLastName("Perez");
        newOwner.setCity("Santiago");

        when(ownerRepository.save(newOwner)).thenReturn(newOwner);

        // Act
        Owner savedOwner = ownerService.createOwner(newOwner);

        // Assert
        assertNotNull(savedOwner);
        assertEquals("Juan", savedOwner.getFirstName());
        assertEquals("Perez", savedOwner.getLastName());
        verify(ownerRepository, times(1)).save(newOwner);
    }

    @Test
    void testUpdateOwner() {
        // Arrange
        Owner existingOwner = new Owner();
        existingOwner.setId(1L);
        existingOwner.setFirstName("Carlos");
        existingOwner.setLastName("Lopez");
        existingOwner.setCity("Antigua");

        when(ownerRepository.findById(1L)).thenReturn(Optional.of(existingOwner));
        when(ownerRepository.save(existingOwner)).thenReturn(existingOwner);

        // Act
        existingOwner.setLastName("Gonzalez");
        existingOwner.setCity("Concepcion");
        Owner updatedOwner = ownerService.updateOwner(existingOwner);

        // Assert
        assertEquals("Gonzalez", updatedOwner.getLastName());
        assertEquals("Concepcion", updatedOwner.getCity());
        verify(ownerRepository, times(1)).save(existingOwner);
    }

    @Test
    void testDeleteOwner() {
        // Arrange
        Owner existingOwner = new Owner();
        existingOwner.setId(1L);
        existingOwner.setFirstName("Maria");
        existingOwner.setLastName("Silva");

        when(ownerRepository.findById(1L)).thenReturn(Optional.of(existingOwner));
        doNothing().when(ownerRepository).deleteById(1L);

        // Act
        ownerService.deleteOwner(1L);

        // Assert
        verify(ownerRepository, times(1)).deleteById(1L);
        verify(ownerRepository, times(1)).findById(1L);
    }
=======
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

    // === Integrante B — Búsquedas y consultas ===

    /**
     *
     */
    @Test
    public void testFindOwnerById() {

        Owner ownerExpected = TObjectCreator.getOwner();

        Mockito.when(this.repository.findById(1))
                .thenReturn(Optional.of(ownerExpected));

        OwnerDTO owner = null;

        try {
            owner = this.ownerService.findById(1);
        } catch (OwnerNotFoundException e) {
            fail(e.getMessage());
        }

        log.info("" + ownerExpected);
        log.info("" + owner);

        assertEquals(ownerExpected.getId(), owner.getId());
        assertEquals(ownerExpected.getFirstName(), owner.getFirstName());
        assertEquals(ownerExpected.getLastName(), owner.getLastName());
    }

    /**
     *
     */
    @Test
    public void testFindByLastName() {

        String FIND_LAST_NAME = "Davis";

        List<Owner> ownersExpected = TObjectCreator.getOwnersForFindByLastName();

        Mockito.when(this.repository.findByLastName(FIND_LAST_NAME))
                .thenReturn(ownersExpected);

        List<OwnerDTO> owners = this.ownerService.findByLastName(FIND_LAST_NAME);

        assertEquals(ownersExpected.size(), owners.size());
        owners.forEach(owner -> assertEquals(FIND_LAST_NAME, owner.getLastName()));
    }

    /**
     *
     */
    @Test
    public void testFindByCity() {

        String FIND_CITY = "Madison";

        List<Owner> ownersExpected = TObjectCreator.getOwnersForFindByCity();

        Mockito.when(this.repository.findByCity(FIND_CITY))
                .thenReturn(ownersExpected);

        List<OwnerDTO> owners = this.ownerService.findByCity(FIND_CITY);

        assertEquals(ownersExpected.size(), owners.size());
        owners.forEach(owner -> assertEquals(FIND_CITY, owner.getCity()));
    }

>>>>>>> 6219b72b25686affd14c4fc2177558bcebe5ee9b
}
