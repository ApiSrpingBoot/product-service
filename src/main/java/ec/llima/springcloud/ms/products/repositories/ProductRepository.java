package ec.llima.springcloud.ms.products.repositories;

import org.springframework.data.repository.CrudRepository;

import ec.llima.springcloud.ms.products.entities.Product;

/**
 * interfaz con CrudRepository que nos permite tener las funcionalidades del crud de JPA 
 * cada tabla necesita su Repository
 * clase 10
 * se debe hacer otro repositorio si tenemos otra fuente que no sea jpa
 */
public interface ProductRepository extends CrudRepository<Product, Long>{
    

}
