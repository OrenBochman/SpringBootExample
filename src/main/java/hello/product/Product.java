package hello.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	private String name;
	private String category;
	private String description;
	
	/* (non-Javadoc)
	 * @see hello.product.IProduct#getId()
	 */
	
	public long getId() {
		return id;
	}
	/* (non-Javadoc)
	 * @see hello.product.IProduct#setId(long)
	 */
	public Product setId(long id) {
		this.id = id;
		return this;
	}
	/* (non-Javadoc)
	 * @see hello.product.IProduct#getName()
	 */
	public String getName() {
		return name;
	}
	/* (non-Javadoc)
	 * @see hello.product.IProduct#setName(java.lang.String)
	 */
	public Product setName(String name) {
		this.name = name;
		return this;
	}
	/* (non-Javadoc)
	 * @see hello.product.IProduct#getCategory()
	 */
	
	public String getCategory() {
		return category;
	}
	/* (non-Javadoc)
	 * @see hello.product.IProduct#setCategory(java.lang.String)
	 */
	public Product setCategory(String category) {
		this.category = category;
		return this;
	}
	/* (non-Javadoc)
	 * @see hello.product.IProduct#getDescription()
	 */
	
	public String getDescription() {
		return description;
	}
	/* (non-Javadoc)
	 * @see hello.product.IProduct#setDescription(java.lang.String)
	 */
	public Product setDescription(String description) {
		this.description = description;
		return this;
	}
}
