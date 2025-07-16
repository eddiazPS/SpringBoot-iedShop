package co.com.ied.shop.iedshop.controllers;

import co.com.ied.shop.iedshop.models.entity.Producto;
import co.com.ied.shop.iedshop.models.service.ServiceProductoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/prod")
public class ProductoConroller {

    @Autowired
    private ServiceProductoI ServiceProducto;

    @GetMapping("/all")
    public List<Producto> index() {
        return ServiceProducto.findall();
    }

}
