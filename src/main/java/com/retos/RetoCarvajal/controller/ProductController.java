package com.retos.RetoCarvajal.controller;
import com.retos.RetoCarvajal.model.Product;
import com.retos.RetoCarvajal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Product")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
/**
 * This class allows mapping the entity Product
 * @author: Laura De Villeros
 */
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAllProducts() { return productService.getAll(); }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") Long id) { return productService.getProduct(id); }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Product save(@RequestBody Product product) { return productService.save(product); }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Product update(@RequestBody Product product) { return productService.update(product); }

    @DeleteMapping("/{id}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Long id) { return productService.delete(id); }
}
