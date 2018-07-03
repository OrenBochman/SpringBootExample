package hello.user;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Comparable<User> {

	public static enum RoleEnum {ADMIN,EXECUTIVE,USER};
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	private int age;
	private String name;
	private String password;
	private String userName;
	private Date passwordExpiration;
	private RoleEnum role;
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public User setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	/**
	 * @return the passwordExpiration
	 */
	public Date getPasswordExpiration() {
		return passwordExpiration;
	}

	/**
	 * @param passwordExpiration the passwordExpiration to set
	 */
	public User setPasswordExpiration(Date passwordExpiration) {
		this.passwordExpiration = passwordExpiration;
		return this;
	}

	public User() {}

	public User(long id, String name) {
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return this.name;
	}

	public User setName(final String name) {
		this.name = name;
		return this;
	}

	public long getId() {
		return this.id;
	}

	public User setId(final long id) {
		this.id = id;
		return this;
	}

	public int getAge() {
		return this.age;
	}
	public User setAge(final int age) {
		this.age=age;
		return this;
	}

	public RoleEnum getRole() {
		return this.role;
	}

	public User setRole(final RoleEnum role) {
		this.role = role;
		return this;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((passwordExpiration == null) ? 0 : passwordExpiration.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (passwordExpiration == null) {
			if (other.passwordExpiration != null)
				return false;
		} else if (!passwordExpiration.equals(other.passwordExpiration))
			return false;
		if (role != other.role)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", age=" + age + ", name=" + name + ", password=" + password + ", userName="
				+ userName + ", passwordExpiration=" + passwordExpiration + ", role=" + role + "]";
	}

	@Override
	public int compareTo(User o){
		return this.getAge()-o.getAge();
	}
}