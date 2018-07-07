package model;

import java.time.LocalDate;

public class Project extends NamedEntity {

	private LocalDate project_start;
	private LocalDate planned_finish;
	private LocalDate actual_finish;

	public Project(String name, LocalDate project_start,
			LocalDate planned_finish, LocalDate actual_finish) {
		this.name = name;
		this.project_start = project_start;
		this.planned_finish = planned_finish;
		this.actual_finish = actual_finish;
	}

	public LocalDate getProject_start() {
		return project_start;
	}

	public void setProject_start(LocalDate project_start) {
		this.project_start = project_start;
	}

	public LocalDate getPlanned_finish() {
		return planned_finish;
	}

	public void setPlanned_finish(LocalDate planned_finish) {
		this.planned_finish = planned_finish;
	}

	public LocalDate getActual_finish() {
		return actual_finish;
	}

	public void setActual_finish(LocalDate actual_finish) {
		this.actual_finish = actual_finish;
	}

	@Override
	public String toString() {
		return "[Project: " + super.toString() + ", project_start="
				+ project_start + ", planned_finish=" + planned_finish
				+ ", actual_finish=" + actual_finish + "]"
				+ System.lineSeparator();
	}

}
