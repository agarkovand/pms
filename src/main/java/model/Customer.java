package model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Customer extends NamedEntity {

	@Getter
	@Setter
	private String country;

	@Getter
	@Setter
	private String city;

	@Getter
	@Setter
	private String email;

	@Getter
	@Setter
	private String phone;

	private List<Project> projects = new ArrayList<>();

	public Customer() {
	}

	public Customer(String name, String country, String city,
			String email, String phone, List<Project> projects) {
		super(name);
		this.country = country;
		this.city = city;
		this.email = email;
		this.phone = phone;
		this.projects = projects;
	}

	public void addProject(Project project) {
		getProjects().add(project);
	}

	public List<Project> getProjects() {
		return projects;
	}

	@Override
	public String toString() {
		return "[Customer: " + super.toString() + ", country="
				+ country + ", city=" + city + "]"
				+ System.lineSeparator() + getProjectsAsString();
	}

	public String getProjectsAsString() {

		StringBuilder sb = new StringBuilder();
		for (Project project : getProjects()) {
			sb.append(project.toString());
			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}

}
