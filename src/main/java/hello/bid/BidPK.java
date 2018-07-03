package hello.bid;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Embeddable;

@Embeddable
public class BidPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8055075619136072707L;
	private long product_id;
    private long user_id;
    private Timestamp timestamp;

    
    
    public BidPK() {
    }


	/**
	 * @return the timestamp
	 */
	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public BidPK setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
		return this;
	}

    
	/**
	 * @return the product_id
	 */
	public long getProduct_id() {
		return product_id;
	}

	/**
	 * @param product_id the product_id to set
	 */
	public BidPK setProduct_id(long product_id) {
		this.product_id = product_id;
		return this;
	}

	/**
	 * @return the user_id
	 */
	public long getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public BidPK setUser_id(long user_id) {
		this.user_id = user_id;
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BidPK [product_id=" + product_id + ", user_id=" + user_id + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (product_id ^ (product_id >>> 32));
		result = prime * result + (int) (user_id ^ (user_id >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BidPK other = (BidPK) obj;
		if (product_id != other.product_id)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

}