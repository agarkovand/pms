package model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends NamedEntity {

	private String country;
	private String city;
	private List<Project> projects = new ArrayList<>();

	public Customer() {
	}

	public Customer(String name, String country, String city) {
		this.name = name;
		this.country = country;
		this.city = city;
	}

	public void addProject(Project project) {
		getProjects().add(project);
	}

	public List<Project> getProjects() {
		return projects;
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

	public String getProjectsAsString() {

		StringBuilder sb = new StringBuilder();
		for (Project project : getProjects()) {
			sb.append(project.toString());
			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return "[Customer: " + super.toString() + ", country=" + country
				+ ", city=" + city + "]" + System.lineSeparator()
				+ getProjectsAsString();
	}

}
