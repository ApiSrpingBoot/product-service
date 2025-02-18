package ec.llima.springcloud.ms.products.services;

import java.util.List;
import java.util.Optional;

import ec.llima.springcloud.ms.products.entities.Product;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);
    

}
