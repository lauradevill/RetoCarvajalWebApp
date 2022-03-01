package com.retos.RetoCarvajal.repository;
import com.retos.RetoCarvajal.model.Product;
import com.retos.RetoCarvajal.repository.crud.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
/**
 * This class defines methods brought from repository for the entity-table Product
 * @author: Laura De Villeros
 */
public class ProductRepository {
    @Autowired
    private IProductRepository iProductRepository;

    /**
     * Methods to bring, save and delete information in DB
     */
    public List<Product> getAll() { return (List<Product>) iProductRepository.findAll(); }
    public Optional<Product> getProduct(Long id) { return iProductRepository.findById(id); }
    public Product save(Product product) { return iProductRepository.save(product); }
    public void delete(Product product) { iProductRepository.delete(product); }
}
