package ru.itmo.service;

import org.springframework.http.HttpStatus;
import ru.itmo.model.Count;
import ru.itmo.model.Product;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.util.List;
import java.util.Optional;

@Remote
public interface ProductService {

    Optional<List<Product>> getProducts();

    Optional<Product> getProduct(Integer id);

    Optional<Product> saveProducts(Product product);

    HttpStatus deleteProducts(Integer id);

    HttpStatus deleteProductsByMeasure(String unit);

    Count countByManufactureId(Integer id);

    Optional<Product> changeProducts(Product product);

    Optional<List<Product>> getDistinctByManufactureCost() ;
}
