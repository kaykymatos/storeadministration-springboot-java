package br.com.kayky.storeadministration.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_seller")
public class Seller implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String fantasyName;
	private String email;
	private String phone;

	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;

	public Seller() {
	}

	public Seller(Long id, String name, String fantasyName, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.fantasyName = fantasyName;
		this.email = email;
		this.phone = phone;
	}

	public Seller(Long id, String name, String fantasyName, String email, String phone, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.fantasyName = fantasyName;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFantasyName() {
		return fantasyName;
	}

	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
