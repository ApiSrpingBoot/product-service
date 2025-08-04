package ec.llima.springcloud.ms.products.services;

import java.util.List;
import java.util.Optional;

import ec.llima.springcloud.ms.products.entities.Product;

/**
 * Una interfas que define todos los metodos que debe tener sin importar 
 * de donde se obtengan o cual sea la fuente
 */
public interface ProductService {

    List<Product> findAll();

    //Optional nos permite controlar o mandejar de forma funcional 
    Optional<Product> findById(Long id);

    Product save(Product product);

    void deleteById(Long id);
    
    Product update(Product product);


}
