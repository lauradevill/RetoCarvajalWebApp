package com.retos.RetoCarvajal.controller;
import com.retos.RetoCarvajal.model.WishListProduct;
import com.retos.RetoCarvajal.service.WishListProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/WishListProduct")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
/**
 * This class allows mapping the entity WishListProduct
 * @author: Laura De Villeros
 */
public class WishListProductController {
    @Autowired
    private WishListProductService wishListProductService;

    @GetMapping("/all")
    public List<WishListProduct> getAllWishListProducts() { return wishListProductService.getAll(); }

    @GetMapping("/{id}")
    public Optional<WishListProduct> getWishListProduct(@PathVariable("id") Long id) {
        return wishListProductService.getWishListProduct(id); }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public WishListProduct save(@RequestBody WishListProduct wlproduct) { return wishListProductService.save(wlproduct); }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public WishListProduct update(@RequestBody WishListProduct wlproduct) { return wishListProductService.update(wlproduct); }

    @DeleteMapping("/{id}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Long id) { return wishListProductService.delete(id); }

    @GetMapping("/nameExist/{name}")
    public boolean nameExist(@PathVariable("name") String name) { return wishListProductService.nameExist(name); }
}
