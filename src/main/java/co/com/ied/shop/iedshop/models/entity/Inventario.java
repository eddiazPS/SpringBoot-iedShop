package co.com.ied.shop.iedshop.models.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="inventario")
@Getter
@Setter
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    // one to one
    @Column(name = "producto_id")
    private Long producto_id;


    @Column(name = "cantidad")
    private Long cantidad;
}
