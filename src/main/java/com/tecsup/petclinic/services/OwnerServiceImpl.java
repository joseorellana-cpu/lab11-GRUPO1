package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.OwnerDTO;
import com.tecsup.petclinic.exceptions.OwnerNotFoundException;
import com.tecsup.petclinic.mappers.OwnerMapper;
import com.tecsup.petclinic.repositories.OwnerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

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

}
