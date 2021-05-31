package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity (name = "Experience")
@Table (name = "experience")
public class Experience {

	@Id
	@GeneratedValue
	private Long id;

	private Long date;

	@ManyToOne(fetch = FetchType.LAZY)

	private Tourist tourist;
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Experience )) return false;
        return id != null && id.equals(((Experience) o).getId());
    }
 
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

	public Experience() {
		// TODO Auto-generated constructor stub
	}

	public Experience(long id, long date) {
		this.id = id;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

}
