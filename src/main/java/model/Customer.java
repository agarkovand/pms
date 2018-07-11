package model;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer {

	private String name;

	@Embedded
	private Address address = new Address();

	private String email;

	private String phone;

	// @Override
	// public String toString() {
	// return "[Customer: " + super.toString() + ", country="
	// + country + ", city=" + city + "]"
	// + System.lineSeparator() + getProjectsAsString();
	// }
	//
	// public String getProjectsAsString() {
	//
	// StringBuilder sb = new StringBuilder();
	// for (Project project : projects) {
	// sb.append(project.toString());
	// sb.append(System.lineSeparator());
	// }
	// return sb.toString();
	// }

}
