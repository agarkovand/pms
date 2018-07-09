package model;

import java.math.BigInteger;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

public class Project extends NamedEntity {

	@Getter
	@Setter
	private int customerId;

	@Getter
	@Setter
	private BigInteger totalBudget;

	@Getter
	@Setter
	private LocalDate startDate;

	@Getter
	@Setter
	private LocalDate deliveryDate;

	public Project(String name, int customerId,
			BigInteger totalBudget, LocalDate startDate,
			LocalDate deliveryDate) {
		super(name);
		this.customerId = customerId;
		this.totalBudget = totalBudget;
		this.startDate = startDate;
		this.deliveryDate = deliveryDate;
	}

	@Override
	public String toString() {
		return "[Project: " + super.toString() + ", project_start: "
				+ startDate + ", delivery_date: " + deliveryDate
				+ ", total_budget =" + totalBudget + "]"
				+ System.lineSeparator();
	}

}
