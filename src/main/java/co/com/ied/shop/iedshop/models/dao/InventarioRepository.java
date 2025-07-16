package co.com.ied.shop.iedshop.models.dao;

import co.com.ied.shop.iedshop.models.entity.Inventario;
import co.com.ied.shop.iedshop.models.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "inventario",path = "inventario")
public interface InventarioRepository extends JpaRepository<Inventario,Long> {


    //select i.cantidad from inventario i where i.producto_id = 5;
    @Query("select i from Inventario i where i.producto_id = ?1")
    public Inventario findInventarioByProdId(Producto numero);

}
