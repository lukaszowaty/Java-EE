package pl.javastart.model;

public class User {
	private String pesel;
	private String firstName;
	private String lastName;
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
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
	
	public User() {}
	public User(String pesel, String fName, String lName) {
		this.pesel = pesel;
		firstName = fName;
		lastName = lName;
	}

}
