package ec.llima.springcloud.ms.products.repositories;

import org.springframework.data.repository.CrudRepository;

import ec.llima.springcloud.ms.products.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
    

}
