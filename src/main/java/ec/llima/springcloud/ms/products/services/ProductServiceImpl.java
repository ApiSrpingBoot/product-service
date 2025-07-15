package ec.llima.springcloud.ms.products.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.llima.springcloud.ms.products.entities.Product;
import ec.llima.springcloud.ms.products.repositories.ProductRepository;

/**
 * Aaqui implementamos nuesta insterfaz ProductService usaremos los metodos que deben ser implementados
 * y estan definidos por al interfaz
 * 
 * Service nos idica que es un servicio - nos da conceprto para saber que es un servicio.
 */
@Service
public class ProductServiceImpl implements ProductService{

    //@Autowired //sirve para inyectar el ProductRepository que usa jpa
    //private ProductRepository repository;

    //tambien se lo puede definir medianre final, ya que recibimos por medio del contructor ya no usamos Autowired
    final private ProductRepository repository; 

    //viene de fabrica lo podemos usar para sacar las propiedades
    final private Environment environment;

    public ProductServiceImpl(ProductRepository repository, Environment environment){
        this.repository=repository;
        this.environment=environment;
    }

    @Override
    @Transactional(readOnly = true) // los metodos que trabajan con acceso a datos son Transactional, pero es una transaccion solo de lectura
    public List<Product> findAll() {
        return ((List<Product>) repository.findAll()).stream().map(product ->{
            product.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
            return product;
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return repository.findById(id).map(product->{
            product.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
            return product;
        });
    }
    

}
