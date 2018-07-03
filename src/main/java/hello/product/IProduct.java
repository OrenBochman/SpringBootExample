package hello.product;

public interface IProduct {

	/**
	 * @return the id
	 */
	long getId();

	/**
	 * @param id the id to set
	 */
	IProduct setId(long id);

	/**
	 * @return the name
	 */
	String getName();

	/**
	 * @param name the name to set
	 */
	Product setName(String name);

	/**
	 * @return the category
	 */
	String getCategory();

	/**
	 * @param category the category to set
	 */
	Product setCategory(String category);

	/**
	 * @return the description
	 */
	String getDescription();

	/**
	 * @param description the description to set
	 */
	Product setDescription(String description);

}