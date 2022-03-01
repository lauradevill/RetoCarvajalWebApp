package com.retos.RetoCarvajal.service;
import com.retos.RetoCarvajal.model.WishListProduct;
import com.retos.RetoCarvajal.repository.WishListProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
/**
 * This class defines business restrictions to the methods brought from repository for the entity-table WishListProduct
 * @author: Laura De Villeros
 */
public class WishListProductService {
    /**
     * WishLstProductRepository instance
     */
    @Autowired
    private WishListProductRepository wishListProductRepository;

    /**
     * Methods from the business to get all products in wishlist, a WishLishProduct by its ID, save, update and delete
     * a WishListProduct
     */
    public List<WishListProduct> getAll(){ return wishListProductRepository.getAll(); }

    public Optional<WishListProduct> getWishListProduct(Long id){ return wishListProductRepository.getWishListProduct(id); }

    public WishListProduct save(WishListProduct wlproduct){
        if (wlproduct.getIdWLProduct() == null){
            return wishListProductRepository.save(wlproduct);
        }else{
            Optional<WishListProduct> element = wishListProductRepository.getWishListProduct(wlproduct.getIdWLProduct());
            if (element.isEmpty()){
                return wishListProductRepository.save(wlproduct);
            }else {
                return wlproduct;
            }
        }
    }

    public WishListProduct update(WishListProduct wlproduct){
        if (wlproduct.getIdWLProduct() != null){
            Optional<WishListProduct> element= wishListProductRepository.getWishListProduct(wlproduct.getIdWLProduct());
            if (!element.isEmpty()){
                if (wlproduct.getId() != null){
                    element.get().setId(wlproduct.getId());
                }
                if (wlproduct.getName() != null){
                    element.get().setName(wlproduct.getName());
                }
                if (wlproduct.getPrice() != null){
                    element.get().setPrice(wlproduct.getPrice());
                }
                if (wlproduct.getQuantity() != null){
                    element.get().setQuantity(wlproduct.getQuantity());
                }
                if (wlproduct.getDescription() != null){
                    element.get().setDescription(wlproduct.getDescription());
                }
                wishListProductRepository.save(element.get());
                return element.get();
            }else{
                return wlproduct;
            }
        }else{
            return wlproduct;
        }
    }

    public boolean delete(Long id){
        boolean aBoolean = getWishListProduct(id).map(wishListProduct -> {
            wishListProductRepository.delete(wishListProduct);
            return true;
        }).orElse(aBoolean=false);
        return aBoolean;
    }

    public boolean nameExist(String name) {
        return wishListProductRepository.nameExist(name);
    }
}
