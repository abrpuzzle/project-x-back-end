package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Tourist;

public interface TouristRepository extends JpaRepository<Tourist, Long> {

}