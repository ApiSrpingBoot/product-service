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


@RestController // este es un controlador rest
@RequestMapping("/api")
public class ProductController {

    //mi servicio con los metodos que puede usar, este lo recibimos por el constructor
    //por ahora como solo existe el ProductServiceImpl que implemento ProductService 
    //ese es el que lo va a usar por defecto 
    final private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public List<Product> getList() {
        return this.service.findAll();
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Product> getDetails(@PathVariable Long id) {
        Optional<Product> optionalProduct = this.service.findById(id);
        if (optionalProduct.isPresent()){
            return ResponseEntity.ok(optionalProduct.orElseThrow());
        }
        return ResponseEntity.notFound().build(); 
    }
    
}
