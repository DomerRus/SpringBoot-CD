package ru.itmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.model.Coordinates;

@Repository
public interface CoordinatesRepository extends JpaRepository<Coordinates, Integer> {
}
