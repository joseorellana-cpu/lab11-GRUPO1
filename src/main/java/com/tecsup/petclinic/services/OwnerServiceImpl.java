package com.tecsup.petclinic.services;
import com.tecsup.petclinic.dtos.OwnerDTO;
import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exceptions.OwnerNotFoundException;
import com.tecsup.petclinic.mappers.OwnerMapper;
import com.tecsup.petclinic.repositories.OwnerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor

public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;

    @Override
    public OwnerDTO findById(Integer id) throws OwnerNotFoundException {
        Optional<Owner> ownerOptional = ownerRepository.findById(id);
        if (ownerOptional.isPresent()) {
            return ownerMapper.mapToDTO(ownerOptional.get());
        } else {
            throw new OwnerNotFoundException("Owner not found with id: " + id);
        }
    }

    @Override
    public List<OwnerDTO> findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName)
                .map(owner -> List.of(ownerMapper.mapToDTO(owner)))
                .orElse(List.of());
    }

    @Override
    public List<OwnerDTO> findByCity(String city) {
        return ownerRepository.findByCity(city).stream()
                .map(ownerMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) throws OwnerNotFoundException {
        if (ownerRepository.existsById(id)) {
            ownerRepository.deleteById(id);
        } else {
            throw new OwnerNotFoundException("Owner not found with id: " + id);
        }
    }

    @Override
    public OwnerDTO create(OwnerDTO ownerDTO) {
        Owner owner = ownerMapper.mapToEntity(ownerDTO);
        Owner savedOwner = ownerRepository.save(owner);
        return ownerMapper.mapToDTO(savedOwner);
    }

    @Override
    public OwnerDTO update(OwnerDTO ownerDto) {
        Owner owner = ownerMapper.mapToEntity(ownerDto);
        Owner updatedOwner = ownerRepository.save(owner);
        return ownerMapper.mapToDTO(updatedOwner);
    }

    @Override
    public List<OwnerDTO> findAll() {
        return ownerRepository.findAll().stream()
                .map(ownerMapper::mapToDTO)
                .collect(Collectors.toList());
    }
    
}
