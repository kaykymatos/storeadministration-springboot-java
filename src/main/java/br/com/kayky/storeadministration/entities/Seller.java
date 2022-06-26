package br.com.kayky.storeadministration.entities;

import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_seller")
public class Seller extends People {
	private String fantasyName;

	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Seller() {
	}

	public Seller(Long id, String name, String fantasyName, String email, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.fantasyName = fantasyName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public Seller(Long id, String name, String fantasyName, String email, String phoneNumber, Address address,User user) {
		super();
		this.id = id;
		this.name = name;
		this.fantasyName = fantasyName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.registrationDate = Instant.now();
		this.user = user;

	}

	public String getFantasyName() {
		return fantasyName;
	}

	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
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
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Seller other = (Seller) obj;
		return Objects.equals(id, other.id);
	}

}
