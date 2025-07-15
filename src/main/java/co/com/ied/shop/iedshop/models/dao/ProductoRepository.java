package co.com.ied.shop.iedshop.models.dao;

import co.com.ied.shop.iedshop.models.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "productos",path = "productos")
public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
