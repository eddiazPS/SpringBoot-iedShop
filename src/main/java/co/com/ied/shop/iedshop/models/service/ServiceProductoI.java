package co.com.ied.shop.iedshop.models.service;

import co.com.ied.shop.iedshop.models.entity.Producto;

import java.util.List;

public interface ServiceProductoI {

    public List<Producto> findall();

    public Producto findById (Long id);

}
