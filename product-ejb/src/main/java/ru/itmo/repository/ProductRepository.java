package ru.itmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import ru.itmo.model.Product;
import ru.itmo.model.enums.UnitOfMeasure;

import java.util.List;

@Component
public interface ProductRepository extends JpaRepository<Product,Integer> {
    void deleteAllByUnitOfMeasure(UnitOfMeasure unitOfMeasure);
    List<Product> findAllByManufacturer_Id(Integer id);

    @Query(value = "SELECT DISTINCT ON (manufacturecost) * FROM product", nativeQuery = true)
    List<Product> findDistinctByManufactureCost();
}
