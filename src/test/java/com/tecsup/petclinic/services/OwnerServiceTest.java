package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.OwnerDTO;
import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exceptions.OwnerNotFoundException;
import com.tecsup.petclinic.mappers.OwnerMapper;
import com.tecsup.petclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceTest {

    @Mock
    private OwnerRepository ownerRepository;

    @Spy
    private OwnerMapper ownerMapper = Mappers.getMapper(OwnerMapper.class);

    @InjectMocks
    private OwnerServiceImpl ownerService;

    // === Integrante B — Búsquedas y consultas ===

    @Test
    void testFindOwnerById() throws OwnerNotFoundException {

        Owner ownerExpected = new Owner(1, "George", "Franklin", "110 W. Liberty St.", "Madison", "6085551023");

        when(ownerRepository.findById(1)).thenReturn(Optional.of(ownerExpected));

        OwnerDTO owner = ownerService.findById(1);

        assertNotNull(owner);
        assertEquals(ownerExpected.getId(), owner.getId());
        assertEquals(ownerExpected.getFirstName(), owner.getFirstName());
        assertEquals(ownerExpected.getLastName(), owner.getLastName());
        assertEquals(ownerExpected.getCity(), owner.getCity());
        verify(ownerRepository).findById(1);
    }

    @Test
    void testFindByLastName() {

        String LAST_NAME = "Davis";

        List<Owner> ownersExpected = List.of(
                new Owner(2, "Betty", LAST_NAME, "638 Cardinal Ave.", "Sun Prairie", "6085551749"),
                new Owner(10, "Harold", LAST_NAME, "563 Friendly St.", "Windsor", "6085553198"));

        when(ownerRepository.findByLastName(LAST_NAME)).thenReturn(ownersExpected);

        List<OwnerDTO> owners = ownerService.findByLastName(LAST_NAME);

        assertEquals(ownersExpected.size(), owners.size());
        owners.forEach(owner -> assertEquals(LAST_NAME, owner.getLastName()));
        verify(ownerRepository).findByLastName(LAST_NAME);
    }

}
