package model;

import java.sql.Date;

public class Project extends NamedEntity {

	private java.sql.Date project_start;
	private java.sql.Date planned_finish;
	private java.sql.Date actual_finish;

	public Project(String name, Date project_start, Date planned_finish,
			Date actual_finish) {
		this.name = name;
		this.project_start = project_start;
		this.planned_finish = planned_finish;
		this.actual_finish = actual_finish;
	}

	public java.sql.Date getProject_start() {
		return project_start;
	}

	public void setProject_start(java.sql.Date project_start) {
		this.project_start = project_start;
	}

	public java.sql.Date getPlanned_finish() {
		return planned_finish;
	}

	public void setPlanned_finish(java.sql.Date planned_finish) {
		this.planned_finish = planned_finish;
	}

	public java.sql.Date getActual_finish() {
		return actual_finish;
	}

	public void setActual_finish(java.sql.Date actual_finish) {
		this.actual_finish = actual_finish;
	}

	@Override
	public String toString() {
		return "[Project: " + super.toString() + ", project_start="
				+ project_start + ", planned_finish=" + planned_finish
				+ ", actual_finish=" + actual_finish + "]";
	}

}
