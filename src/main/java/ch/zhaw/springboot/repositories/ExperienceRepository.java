package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.zhaw.springboot.entities.Experience;
	
	@Repository
	public interface ExperienceRepository extends JpaRepository<Experience, Long> {

}
