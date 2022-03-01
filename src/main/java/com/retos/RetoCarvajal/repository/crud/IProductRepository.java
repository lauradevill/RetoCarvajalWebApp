package com.retos.RetoCarvajal.repository.crud;
import com.retos.RetoCarvajal.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<Product,Long> {
}
