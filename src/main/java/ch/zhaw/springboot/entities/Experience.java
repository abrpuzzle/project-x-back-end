package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String date;

	@JsonIgnore
	@ManyToOne(targetEntity = Tourist.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "touristId")
	private Tourist tourist;

	@JsonIgnore
	@ManyToOne(targetEntity = Trip.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "tripId")
	private Trip trip;

	public Experience() {

	}

	public Experience(long id, String date) {
		this.id = id;
		this.date = date;
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

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public Tourist getTourist() {
		return this.tourist;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Experience))
			return false;
		return id != null && id.equals(((Experience) o).getId());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

}
