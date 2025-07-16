package co.com.ied.shop.iedshop.models.entity;


import jakarta.persistence.*;


import java.math.BigDecimal;

@Entity
@Table(name="inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // one to one
    @Column(name = "producto_id")
    private Long producto_id;


    @Column(name = "cantidad")
    private Long cantidad;




    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Long producto_id) {
        this.producto_id = producto_id;
    }
}
