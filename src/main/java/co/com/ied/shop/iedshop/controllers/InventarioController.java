package co.com.ied.shop.iedshop.controllers;

import co.com.ied.shop.iedshop.exception.DataNotFoundException;
import co.com.ied.shop.iedshop.models.DTO.InventarioDTO;
import co.com.ied.shop.iedshop.models.entity.Inventario;
import co.com.ied.shop.iedshop.models.entity.Producto;
import co.com.ied.shop.iedshop.models.service.ServiceInventarioI;
import co.com.ied.shop.iedshop.models.service.ServiceInventarioImp;
import co.com.ied.shop.iedshop.models.service.ServiceProductoI;
import co.com.ied.shop.iedshop.models.service.ServiceProductoImp;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/inve")
@Slf4j
public class InventarioController {

    private ServiceProductoI serviceProducto;
    private ServiceInventarioI serviceInventario;

    @Autowired
    public InventarioController(ServiceProductoI serviceProducto, ServiceInventarioI serviceInventario) {
        this.serviceInventario = serviceInventario;
        this.serviceProducto = serviceProducto;
    }



    @GetMapping("/producto/{id}")
    public ResponseEntity<?> inventarioProducto(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();

        Producto productoConsulta = serviceProducto.findById(id);
        Inventario inventarioConsulta = serviceInventario.findInventarioByProdId(productoConsulta);

        response.put("mensaje",  "Se consulto el inventario del productoId:"+id+" cantidad de productos:"+inventarioConsulta.getCantidad());
        response.put("inventario", inventarioConsulta);

        return new  ResponseEntity< Map<String, Object>>(response, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> ActualizaInventarioProducto(@Valid @RequestBody InventarioDTO inventarioNewDto, @PathVariable Long id) {
        Inventario inventarioResp = new Inventario();

        Map<String, Object> response = new HashMap<>();
        Producto productoActual = serviceProducto.findById(id);
        if (productoActual == null) throw new DataNotFoundException("productoId: "+id+" No exite en base de datos");
        inventarioResp = serviceInventario.inventarioProducto(inventarioNewDto,productoActual,id);
        response.put("mensaje",  "Se actualizo el inventario productoId:"+id+" cantidad de productos:"+inventarioResp.getCantidad());
        response.put("inventario", inventarioResp);
        System.out.println("*********** Actualizacion inventario producto id :"+inventarioResp.getProducto_id()+" fue exitos");
        return new ResponseEntity< Map<String, Object>>(response, HttpStatus.OK);
    }

}
