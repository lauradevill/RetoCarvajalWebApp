package com.retos.RetoCarvajal.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="products")
/**
 * This class defines the entity-table Product
 * @author: Laura De Villeros
 */
public class Product {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float price;
    private Integer quantity;
    private String description;
}
