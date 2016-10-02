package pl.javastart.usermanager.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({
	@NamedQuery(name="User.findAll", query = "SELECT u FROM User u"),
	@NamedQuery(name="User.findById", query = "SELECT u FROM User u WHERE u.id = :id")
})
@XmlRootElement
public class User implements Serializable {

	private static final long serialVersionUID = 1L; 

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String firstName;
    private String lastName;
    private String telephone;
    private String pesel;
    @OneToOne(cascade=CascadeType.ALL)
    private UserDetails details;
     
    User() {}
     
    public User(String firstName, String lastName, String telephone, String pesel) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setTelephone(telephone);
        this.setPesel(pesel);
    }
     
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " " + getTelephone() + " " + getPesel() +
                " (" + getDetails().getAddress() + " " + getDetails().getCountry() + ")";
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public UserDetails getDetails() {
		return details;
	}

	public void setDetails(UserDetails details) {
		this.details = details;
	}
}

