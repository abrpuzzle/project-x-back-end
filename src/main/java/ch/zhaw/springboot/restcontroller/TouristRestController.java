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

import ch.zhaw.springboot.entities.Tourist;
import ch.zhaw.springboot.repositories.TouristRepository;

@RestController
public class TouristRestController {
	@Autowired
	private TouristRepository repository;

	@GetMapping("projectx/tourist")
	public ResponseEntity<List<Tourist>> getTourist() {
		List<Tourist> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("projectx/tourist/{id}")
	public ResponseEntity<Tourist> getTouristById(@PathVariable("id") long id) {
		Optional<Tourist> result = this.repository.findById(id);

		if (result.isPresent()) {
			return new ResponseEntity<Tourist>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Tourist>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("projectx/tourist")
	public ResponseEntity<Tourist> createTourist(@RequestBody Tourist tourist) {
		Tourist result = this.repository.save(tourist);
		return new ResponseEntity<Tourist>(result, HttpStatus.OK);
	}


	@DeleteMapping("projectx/tourist/{id}")
	void deleteTourist(@PathVariable long id) {
		repository.deleteById(id);
	}
}