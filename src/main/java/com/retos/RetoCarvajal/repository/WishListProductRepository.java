package com.retos.RetoCarvajal.repository;
import com.retos.RetoCarvajal.model.WishListProduct;
import com.retos.RetoCarvajal.repository.crud.IWishListProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
/**
 * This class defines methods brought from repository for the entity-table WishListProduct
 * @author: Laura De Villeros
 */
public class WishListProductRepository {
    @Autowired
    private IWishListProductRepository iWishListProductRepository;

    /**
     * Methods to bring, save and delete information in DB
     */
    public List<WishListProduct> getAll() { return (List<WishListProduct>) iWishListProductRepository.findAll(); }
    public Optional<WishListProduct> getWishListProduct(Long id) { return iWishListProductRepository.findById(id); }
    public WishListProduct save(WishListProduct wlproduct) { return iWishListProductRepository.save(wlproduct); }
    public void delete(WishListProduct wlproduct) { iWishListProductRepository.delete(wlproduct); }

    public boolean nameExist(String name) {
        Optional<WishListProduct> productWithName = iWishListProductRepository.findByName(name);
        return !productWithName.isEmpty();
    }
}
