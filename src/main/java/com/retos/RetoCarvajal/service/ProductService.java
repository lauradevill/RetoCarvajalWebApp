package com.retos.RetoCarvajal.service;
import com.retos.RetoCarvajal.model.Product;
import com.retos.RetoCarvajal.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
/**
 * This class defines business restrictions to the methods brought from repository for the entity-table Product
 * @author: Laura De Villeros
 */
public class ProductService {
    /**
     * ProductRepository instance
     */
    @Autowired
    private ProductRepository productRepository;

    /**
     * Methods from the business to get all products, a product by its ID, save a product, update and delete
     */
    public List<Product> getAll(){ return productRepository.getAll(); }

    public Optional<Product> getProduct(Long id){ return productRepository.getProduct(id);}

    public Product save(Product product){
        if (product.getId() == null){
            return productRepository.save(product);
        }else{
            Optional<Product> element = productRepository.getProduct(product.getId());
            if (element.isEmpty()){
                return productRepository.save(product);
            }else {
                return product;
            }
        }
    }

    public Product update(Product product){
        if (product.getId() != null){
            Optional<Product> element= productRepository.getProduct(product.getId());
            if (!element.isEmpty()){
                if (product.getName() != null){
                    element.get().setName(product.getName());
                }
                if (product.getPrice() != null){
                    element.get().setPrice(product.getPrice());
                }
                if (product.getQuantity() != null){
                    element.get().setQuantity(product.getQuantity());
                }
                if (product.getDescription() != null){
                    element.get().setDescription(product.getDescription());
                }
                productRepository.save(element.get());
                return element.get();
            }else{
                return product;
            }
        }else{
            return product;
        }
    }

    public boolean delete(Long id){
        boolean aBoolean = getProduct(id).map(product -> {
            productRepository.delete(product);
            return true;
        }).orElse(aBoolean=false);
        return aBoolean;
    }
}