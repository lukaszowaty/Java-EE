package pl.javastart.security.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String username;
	private String password;
	@ElementCollection
	@CollectionTable(name = "roles",
			joinColumns = @JoinColumn(name="username", referencedColumnName="username"))
	@Column(name = "role")
	private Set<String> roles = new HashSet<>();
	
	User() {}
	
	public User(String username, String password, String role) {
		this.setUsername(username);
		this.setPassword(password);
		this.getRoles().add(role);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

}
