package ch.zhaw.springboot.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "trip")
@Entity(name = "Trip")
public class Trip {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "city")
	private String city;

	@OneToMany(targetEntity = Experience.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "trip")
	private List<Experience> experiences = new ArrayList<>();

	public Trip(String city) {
		this.city = city;
	}

	public Trip() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public List<Experience> getExperience() {
		return this.experiences;
	}

	public void addExperience(Experience experience) {
		experiences.add(experience);
		experience.setTrip(this);
	}

	public void removeExperience(Experience experience) {
		experiences.remove(experience);
		experience.setTrip(null);
	}

}
