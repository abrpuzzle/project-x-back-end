package ch.zhaw.springboot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "route")
public class Route extends Trip {

	@Column(name = "length")
	private int length;

	public Route() {
		super();
	}

	public Route(String name, int length) {
		super(name);
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
