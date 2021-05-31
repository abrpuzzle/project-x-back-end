package ch.zhaw.springboot.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("projectx/experience/{id}")
	public ResponseEntity<Experience> getExperienceById(@PathVariable("id") long id) {
		Optional<Experience> result = this.repository.findById(id);

		if (result.isPresent()) {
			return new ResponseEntity<Experience>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Experience>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Experience> addExperience(@RequestBody Experience experience) {
		repository.save(experience);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("projectx/experience/{id}")
	void deleteExperience(@PathVariable Long id) {
		repository.deleteById(id);
	}
}