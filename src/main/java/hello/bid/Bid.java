package hello.bid;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import hello.product.Product;
import hello.user.User;

@Entity
public class Bid implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2900967895050675107L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public Bid setId(long id) {
		this.id = id;
		return this;
	}

	private long product_id;
	private long user_id;
	private Timestamp timestamp;
	private double price;

	public Bid() {};

	@ManyToOne
	@MapsId("user_id")
	private User user;

	@ManyToOne()
	@MapsId("product_id")
	private Product product;

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public Bid setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp; 
		return this;
	}
	public long getUser_id() {
		return user_id;
	}
	public Bid setUser_id(long user_id) {
		this.user_id = user_id; 
		return this;
	}
	public long getProduct_id() {
		return product_id;
	}
	public Bid setProduct_id(long product_id) {
		this.product_id = product_id; 
		return this;
	}
	
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param d the price to set
	 */
	public Bid setPrice(double price) {
		this.price = price;
		return this;
	}
}
