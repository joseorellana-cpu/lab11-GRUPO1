package com.tecsup.petclinic.services;

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
}
