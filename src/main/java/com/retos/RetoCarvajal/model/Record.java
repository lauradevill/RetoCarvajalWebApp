package com.retos.RetoCarvajal.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="record")
/**
 * This class defines the entity-table Record
 * @author: Laura De Villeros
 */
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRecord;
    private Long idWLProduct;
    private Long id;
    private String name;
    private Float price;
    private Integer quantity;
    private String description;
}
