package model;

public class Customer extends NamedEntity {

	private String country;
	private String city;

	public Customer() {
	}

	public Customer(String name, String country, String city) {
		this.name = name;
		this.country = country;
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "[Customer: " + super.toString() + ", country=" + country
				+ ", city=" + city + "]";
	}

}
