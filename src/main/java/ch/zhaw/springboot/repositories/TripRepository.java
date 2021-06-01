package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.zhaw.springboot.entities.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
}
