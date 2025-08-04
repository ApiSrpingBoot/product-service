package ec.llima.springcloud.ms.products.controllers;

import org.springframework.web.bind.annotation.RestController;

import ec.llima.springcloud.ms.products.entities.Product;
import ec.llima.springcloud.ms.products.services.ProductService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




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

    @PostMapping("/save")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product productSaved = this.service.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> optionalProduct = this.service.findById(id);
        if (optionalProduct.isPresent()){
            Product productFound = optionalProduct.orElseThrow();
            productFound.setName(product.getName());
            productFound.setPrice(product.getPrice());
            productFound.setCreateAt(product.getCreateAt());
            Product productUpdated = this.service.update(productFound);
            return ResponseEntity.status(HttpStatus.CREATED).body(productUpdated);
        }          
        return ResponseEntity.notFound().build();  
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Product> optionalProduct = this.service.findById(id);
        if (optionalProduct.isPresent()){
            this.service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build(); 
    }
    
}
