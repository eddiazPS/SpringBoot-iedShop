package co.com.ied.shop.iedshop.models.service;

import co.com.ied.shop.iedshop.models.DTO.InventarioDTO;
import co.com.ied.shop.iedshop.models.entity.Inventario;
import co.com.ied.shop.iedshop.models.entity.Producto;

public interface ServiceInventarioI {

    public Inventario inventarioProducto (InventarioDTO inventarioDTO, Producto producto_id, Long inventario_id);

    public Inventario findByProductId(Long id);

    public Inventario findInventarioByProdId(Producto id);

}
