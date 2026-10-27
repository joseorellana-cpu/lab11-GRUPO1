package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;

import java.util.List;

/**
 *
 */
public interface OwnerService {

    Owner createOwner(Owner owner);

    Owner updateOwner(Owner owner);

    void deleteOwner(Integer id);

    Owner findById(Integer id);

    List<Owner> findAll();
}