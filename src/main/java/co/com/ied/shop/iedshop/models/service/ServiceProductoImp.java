package co.com.ied.shop.iedshop.models.service;

import co.com.ied.shop.iedshop.models.dao.ProductoRepository;
import co.com.ied.shop.iedshop.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceProductoImp implements ServiceProductoI{

    private ProductoRepository productoDao;

    @Autowired
    public ServiceProductoImp(ProductoRepository productoDao) {
        this.productoDao = productoDao;
    }
    @Override
    public List<Producto> findall() {
        return (List<Producto>)productoDao.findAll();
    }
    @Override
    public Producto findById(Long id) {
        return productoDao.findById(id).orElse(null);
    }
    
}
