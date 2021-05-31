package ch.zhaw.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Experience;
import ch.zhaw.springboot.repositories.ExperienceRepository;

@RestController
public class ExperienceRestController {

	@Autowired
	private ExperienceRepository repository;

	@GetMapping("projectx/experience")
	public ResponseEntity<List<Experience>> getExperience() {
		List<Experience> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}