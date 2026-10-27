package com.tecsup.petclinic.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
import java.time.LocalDate;

/**
 *
 * @author jgomezm
 */
=======
>>>>>>> 6219b72b25686affd14c4fc2177558bcebe5ee9b
@Entity(name = "owners")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Owner {

<<<<<<< HEAD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private String address;

    private String city;

    private String telephone;
}
=======
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String address;
	private String city;
	private String telephone;

}
>>>>>>> 6219b72b25686affd14c4fc2177558bcebe5ee9b
