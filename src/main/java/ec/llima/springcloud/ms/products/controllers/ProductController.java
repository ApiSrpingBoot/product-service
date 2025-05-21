package ec.llima.springcloud.ms.products.controllers;

import org.springframework.web.bind.annotation.RestController;

import ec.llima.springcloud.ms.products.entities.Product;
import ec.llima.springcloud.ms.products.services.ProductService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class ProductController {

    final private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/lista")
    public List<Product> getList() {
        System.out.println("si se llamo>>>>>>>>>>>>>>>>>>>");
        return this.service.findAll();
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Product> getDetails(@PathVariable Long id) {
        System.out.println("si se llamo>>>>>>>>>>>>>>>>>>>");
        Optional<Product> optionalProduct = this.service.findById(id);
        if (optionalProduct.isPresent()){
            return ResponseEntity.ok(optionalProduct.orElseThrow());
        }
        return ResponseEntity.notFound().build(); 
    }
    
}
