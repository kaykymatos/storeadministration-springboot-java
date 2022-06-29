package br.com.kayky.storeadministration.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_address")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String street;
	private String houseNumber;
	private String state;
	private String addressReferences;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant registrationDate;


	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Address() {
		this.registrationDate = Instant.now();
	}

	public Address(Long id, String street, String houseNumber, String state, String addressReferences,User user) {
		super();
		this.id = id;
		this.street = street;
		this.houseNumber = houseNumber;
		this.state = state;
		this.addressReferences = addressReferences;
		this.registrationDate = Instant.now();
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddressReferences() {
		return addressReferences;
	}

	public void setAddressReferences(String addressReferences) {
		this.addressReferences = addressReferences;
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
		Address other = (Address) obj;
		return Objects.equals(id, other.id);
	}

}
