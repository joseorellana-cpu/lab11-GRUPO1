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

}
