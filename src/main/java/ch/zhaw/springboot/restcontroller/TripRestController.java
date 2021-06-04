package ch.zhaw.springboot.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Trip;
import ch.zhaw.springboot.repositories.TripRepository;

@RestController
@CrossOrigin
public class TripRestController {
	@Autowired
	private TripRepository repository;

	@GetMapping("projectx/trip")
	public ResponseEntity<List<Trip>> getTrip() {
		List<Trip> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("projectx/trip/{id}")
	public ResponseEntity<Trip> getTripById(@PathVariable("id") Long id) {
		Optional<Trip> result = this.repository.findById(id);

		if (result.isPresent()) {
			return new ResponseEntity<Trip>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Trip>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Trip> addTrip(@RequestBody Trip trip) {
		repository.save(trip);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("projectx/trip/{id}")
	void deleteTourist(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}