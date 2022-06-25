package br.com.kayky.storeadministration.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_client")
public class Client extends People {

	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;

	public Client() {
	}

	public Client(Long id, String name, String email, String phoneNumber,Address address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}


	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
