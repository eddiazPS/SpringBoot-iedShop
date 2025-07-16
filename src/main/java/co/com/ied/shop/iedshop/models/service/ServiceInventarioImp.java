package co.com.ied.shop.iedshop.models.service;

import co.com.ied.shop.iedshop.models.DTO.InventarioDTO;
import co.com.ied.shop.iedshop.models.dao.InventarioRepository;
import co.com.ied.shop.iedshop.models.dao.ProductoRepository;
import co.com.ied.shop.iedshop.models.entity.Inventario;
import co.com.ied.shop.iedshop.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceInventarioImp implements ServiceInventarioI{

    private InventarioRepository inventarioRepository;
    private ProductoRepository productoRepository;

    @Autowired
    public ServiceInventarioImp (InventarioRepository inventarioRepository , ProductoRepository productoRepository ) {
        this.inventarioRepository = inventarioRepository;
    }

    @Override
    @Transactional
    public Inventario inventarioProducto(InventarioDTO inventarioDTO, Producto producto_id, Long inventario_id) {

        Inventario inventarioNew = new Inventario(inventario_id, inventarioDTO.getCantidad(),producto_id);
        inventarioRepository.save(inventarioNew);
        return inventarioNew;
    }

    @Override
    public Inventario findByProductId(Long id) {

        return inventarioRepository.findById(id).get();
    }

    @Override
    public Inventario findInventarioByProdId(Producto id) {
        return  inventarioRepository.findInventarioByProdId(id);
    }
}
