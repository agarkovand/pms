package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Embedded
	private Address address;

	@ElementCollection
	@CollectionTable(name = "customer_email", joinColumns = @JoinColumn(name = "customer_id"))
	private List<Email> emails = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "customer_phone", joinColumns = @JoinColumn(name = "customer_id"))
	@Column(name = "phone")
	private List<String> phones = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", nullable = false)
	private List<Project> projects = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public List<String> getPhones() {
		return phones;
	}

	public List<Project> getProjects() {
		return projects;
	}

}
