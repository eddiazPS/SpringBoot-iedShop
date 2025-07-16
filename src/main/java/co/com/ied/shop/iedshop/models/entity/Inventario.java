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

    @Column(name = "cantidad")
    private Long cantidad;

    @OneToOne ( cascade = CascadeType.ALL)
    @JoinColumn (name = "producto_id")
    private Producto producto_id;

    public Inventario() {
    }

    public Inventario(Producto producto_id, Long cantidad) {
        this.producto_id = producto_id;
        this.cantidad = cantidad;
    }

    public Inventario(Long id, Long cantidad,Producto producto_id  ) {
        this.cantidad = cantidad;
        this.id = id;
        this.producto_id = producto_id;
    }

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

    public Producto getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Producto producto_id) {
        this.producto_id = producto_id;
    }
}
