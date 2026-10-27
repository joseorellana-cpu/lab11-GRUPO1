package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.repositories.OwnerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    @Override
    public Owner createOwner(Owner owner) {
        log.info("Creating owner: {}", owner);
        return ownerRepository.save(owner);
    }

    @Override
    public Owner updateOwner(Owner owner) {
        log.info("Updating owner: {}", owner);
        Owner existingOwner = ownerRepository.findById(owner.getId())
                .orElseThrow(() -> new RuntimeException("Owner not found with id: " + owner.getId()));
        return ownerRepository.save(existingOwner);
    }

    @Override
    public void deleteOwner(Integer id) {
        log.info("Deleting owner with id: {}", id);
        ownerRepository.deleteById(id);
    }

    @Override
    public Owner findById(Integer id) {
        Optional<Owner> owner = ownerRepository.findById(id);
        if (owner.isPresent()) {
            return owner.get();
        }
        throw new RuntimeException("Owner not found with id: " + id);
    }

    @Override
    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }
}