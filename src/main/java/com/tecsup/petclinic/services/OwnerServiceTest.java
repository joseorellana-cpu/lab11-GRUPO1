package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.OwnerDTO;
import com.tecsup.petclinic.exceptions.OwnerNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class OwnerServiceTest {

    @Autowired
    private OwnerService ownerService;

    
    //Test: Buscar owner con ID que NO existe
    
    @Test
    public void testFindOwnerById_NotFound() {

        Integer NON_EXISTENT_ID = 9999;

        assertThrows(OwnerNotFoundException.class, () -> {
            ownerService.findById(NON_EXISTENT_ID);
        });
    }

    
    //Test: Borrar owner con ID que NO existe
    
    @Test
    public void testDeleteOwner_NotFound() {

        Integer NON_EXISTENT_ID = 9999;

        assertThrows(OwnerNotFoundException.class, () -> {
            ownerService.delete(NON_EXISTENT_ID);
        });
    }

    
    //Test: Buscar por apellido que NO existe
     
    @Test
    public void testFindByLastName_Empty() {

        String NON_EXISTENT_LAST_NAME = "Xxxxxxxxx";

        List<OwnerDTO> owners = ownerService.findByLastName(NON_EXISTENT_LAST_NAME);

        assertNotNull(owners);
        assertEquals(0, owners.size());
    }
}