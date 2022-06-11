package ru.itmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.itmo.model.Coordinates;

@Component
public interface CoordinatesRepository extends JpaRepository<Coordinates, Integer> {
}
