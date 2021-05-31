package ch.zhaw.springboot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pointOfIntrest")
public class PointOfInterest extends Trip {

	@Column(name = "name")
	private String name;

	public PointOfInterest() {
		super();
	}

	public PointOfInterest(String city, String name) {
		super(city);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
