package model;

import lombok.Getter;
import lombok.Setter;

public abstract class NamedEntity extends BaseEntity {

	@Getter
	@Setter
	protected String name;

	public NamedEntity() {

	}

	public NamedEntity(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return super.toString() + ", name=" + name;
	}

}
