package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String date;

	@JsonIgnore
	@ManyToOne
	private Tourist tourist;

	@JsonIgnore
	@ManyToOne
	private Trip trip;

	public Experience() {

	}

	public Experience(long id, String date, Tourist tourist, Trip trip) {
		this.id = id;
		this.date = date;
		this.tourist = tourist;
		this.trip = trip;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setTourist(Tourist tourist) {
		this.tourist = tourist;
	}

	public Trip getTrip() {
		return this.trip;
	}

	public Tourist getTourist() {
		return this.tourist;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

}
