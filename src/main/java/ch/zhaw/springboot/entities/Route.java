package ch.zhaw.springboot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Route")
@Table(name = "route")
public class Route extends Trip {

	@Column(name = "length")
	private int length;

	public Route() {
		super();
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "trip_id")
	private Trip trip;

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
