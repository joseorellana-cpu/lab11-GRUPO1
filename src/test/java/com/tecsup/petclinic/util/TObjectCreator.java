package com.tecsup.petclinic.util;

import com.tecsup.petclinic.dtos.PetDTO;
import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.entities.Pet;

import java.util.ArrayList;
import java.util.List;

public class TObjectCreator {

	public static Pet getPet() {
		return new Pet(1,"Leo",1,1, null);
	}

	public static Pet newPet() {
		Pet newEntity = new Pet();
		newEntity.setName("Punky");
		newEntity.setTypeId(1);
		newEntity.setOwnerId(1);
		return newEntity;
	}

	public static Pet newPetCreated() {
		Pet pet = newPet();
		pet.setId(1000);
		return pet;
	}

	public static PetDTO newPetDTO() {
		PetDTO newDTO = new PetDTO();
		newDTO.setName("Punky");
		newDTO.setTypeId(1);
		newDTO.setOwnerId(1);
		return newDTO;
	}

	public static PetDTO newPetDTOCreated() {
		PetDTO petDTO = newPetDTO();
		petDTO.setId(1000);
		return petDTO;
	}


	public static Pet newPetForUpdate() {
		return new Pet(0,"Bear",1,1,null);
	}

	public static Pet newPetCreatedForUpdate() {
		Pet pet = newPetForUpdate();
		pet.setId(4000);
		return pet;
	}

	public static Pet newPetForDelete() {
		return new Pet(0,"Bird",1,1, null);
	}

	public static Pet newPetCreatedForDelete() {
		Pet pet = newPetForDelete();
		pet.setId(2000);
		return pet;
	}

	public static List<Pet> getPetsForFindByName() {
		List<Pet> pets  = new ArrayList<Pet>();
		pets.add(new Pet(1,"Leo",1,1, null));
		return pets;
	}

	public static List<Pet> getPetsForFindByTypeId() {
		List<Pet> pets  = new ArrayList<Pet>();
		pets.add(new Pet(9,"Lucky",5,7, null));
		pets.add(new Pet(11,"Freddy",5,9, null));
		return pets;
	}

	public static List<Pet> getPetsForFindByOwnerId() {
		List<Pet> pets  = new ArrayList<Pet>();
		pets.add(new Pet(12,"Lucky",2,10, null));
		pets.add(new Pet(13,"Sly",1,10, null));
		return pets;
	}

	public static Owner getOwner() {
		return new Owner(1, "George", "Franklin", "110 W. Liberty St.", "Madison", "6085551023");
	}

	public static List<Owner> getOwnersForFindByLastName() {
		List<Owner> owners = new ArrayList<Owner>();
		owners.add(new Owner(2, "Betty", "Davis", "638 Cardinal Ave.", "Sun Prairie", "6085551749"));
		owners.add(new Owner(10, "Harold", "Davis", "563 Friendly St.", "Windsor", "6085553198"));
		return owners;
	}

	public static List<Owner> getOwnersForFindByCity() {
		List<Owner> owners = new ArrayList<Owner>();
		owners.add(new Owner(1, "George", "Franklin", "110 W. Liberty St.", "Madison", "6085551023"));
		owners.add(new Owner(6, "Jean", "Coleman", "105 N. Lake St.", "Madison", "6085552654"));
		return owners;
	}
}
