package ec.llima.springcloud.ms.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.llima.springcloud.ms.products.entities.Product;
import ec.llima.springcloud.ms.products.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    //@Autowired
    //private ProductRepository repository;

    final private ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository){
        this.repository=repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }
    

}
