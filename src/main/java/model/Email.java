package model;

import javax.persistence.Embeddable;

@Embeddable
public class Email {

	private String email;

	private String kind;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

}
