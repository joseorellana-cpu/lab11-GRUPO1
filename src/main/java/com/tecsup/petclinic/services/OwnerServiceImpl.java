package com.tecsup.petclinic.services;

<<<<<<< HEAD
import com.tecsup.petclinic.entities.Owner;
=======
import com.tecsup.petclinic.dtos.OwnerDTO;
import com.tecsup.petclinic.exceptions.OwnerNotFoundException;
import com.tecsup.petclinic.mappers.OwnerMapper;
>>>>>>> 6219b72b25686affd14c4fc2177558bcebe5ee9b
import com.tecsup.petclinic.repositories.OwnerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;

/**
 *
 */
=======

>>>>>>> 6219b72b25686affd14c4fc2177558bcebe5ee9b
@Service
@Slf4j
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

<<<<<<< HEAD
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
=======
	private final OwnerRepository ownerRepository;
	private final OwnerMapper ownerMapper;

	/**
	 *
	 * @param id
	 * @return
	 * @throws OwnerNotFoundException
	 */
	@Override
	public OwnerDTO findById(Integer id) throws OwnerNotFoundException {

		return ownerRepository.findById(id)
				.map(ownerMapper::mapToDto)
				.orElseThrow(() -> new OwnerNotFoundException("Record not found...!"));
	}

	/**
	 *
	 * @param lastName
	 * @return
	 */
	@Override
	public List<OwnerDTO> findByLastName(String lastName) {

		return ownerRepository.findByLastName(lastName)
				.stream()
				.map(ownerMapper::mapToDto)
				.toList();
	}

	/**
	 *
	 * @param city
	 * @return
	 */
	@Override
	public List<OwnerDTO> findByCity(String city) {

		return ownerRepository.findByCity(city)
				.stream()
				.map(ownerMapper::mapToDto)
				.toList();
	}

}
>>>>>>> 6219b72b25686affd14c4fc2177558bcebe5ee9b
