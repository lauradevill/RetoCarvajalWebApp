package com.retos.RetoCarvajal.model;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="wishListProducts")
/**
 * This class defines the entity-table WishListProduct
 * @author: Laura De Villeros
 */
public class WishListProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idWLProduct;
    private Long id;
    private String name;
    private Float price;
    private Integer quantity;
    private String description;
}
