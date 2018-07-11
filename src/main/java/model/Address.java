package model;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Address {
	public String addressLine;
	public String city;
	public String region;
	public String country;
	public String zipCode;

	public Address() {
	}
}