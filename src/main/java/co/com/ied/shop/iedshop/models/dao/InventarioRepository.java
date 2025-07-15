package co.com.ied.shop.iedshop.models.dao;

import co.com.ied.shop.iedshop.models.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Inventario",path = "Inventario")
public interface InventarioRepository extends JpaRepository<Inventario,Long> {
}
