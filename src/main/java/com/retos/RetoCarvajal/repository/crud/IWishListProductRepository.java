package com.retos.RetoCarvajal.repository.crud;
import com.retos.RetoCarvajal.model.WishListProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IWishListProductRepository extends CrudRepository<WishListProduct, Long> {
    Optional<WishListProduct> findByName(String name);
}
