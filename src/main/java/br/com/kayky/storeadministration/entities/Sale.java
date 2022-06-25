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
@Table(name = "tb_sale")
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double quantity;
	private Double price;

	@ManyToOne
	@JoinColumn(name = "seller_id")
	private Seller seller;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public Sale() {
	}

	public Sale(Sale sale) {
		this.quantity = sale.quantity;
		this.seller = sale.seller;
		this.product = sale.product;
		this.price = this.calcTotalValue(product, quantity);
	}

	public Sale(Long id, Double quantity, Seller seller, Product product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.seller = seller;
		this.product = product;
		this.price = this.calcTotalValue(product, quantity);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double calcTotalValue(Product prod, double quantity) {
		return prod.getPrice() * quantity;

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
		Sale other = (Sale) obj;
		return Objects.equals(id, other.id);
	}
}
