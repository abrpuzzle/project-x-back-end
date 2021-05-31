package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.zhaw.springboot.entities.Tourist;

@Repository
public interface TouristRepository extends JpaRepository<Tourist, Long> {

}