package com.tecsup.petclinic.mappers;
import com.tecsup.petclinic.dtos.OwnerDTO;
import com.tecsup.petclinic.entities.Owner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class OwnerMapper {
    Owner mapToEntity(OwnerDTO dto);
    OwnerDTO mapToDTO(Owner entity);
}
