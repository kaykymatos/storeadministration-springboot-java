package br.com.kayky.storeadministration.entities;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_client")
public class Client extends People {

	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	public Client() {
	}

	public Client(Long id, String name, String email, String phoneNumber,Address address,User user) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.registrationDate = Instant.now();
		this.user = user;
	}


	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public User getUser() {
		return user;
	}
	public Instant getRegistrationDate() {
		return registrationDate;
	}
}
