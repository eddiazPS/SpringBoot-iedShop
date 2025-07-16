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

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(InventarioController.class);

    /**
     *Controlador que consulta el inventario con el producto id
     *
     * #endPoint = serverPath/inve/producto/{id}
     *
     * @param id
     * @return ResponseEntity  inventario consultado y mensaje
     *
     */
    @GetMapping("/producto/{id}")
    public ResponseEntity<?> inventarioProducto(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        Producto productoConsulta = serviceProducto.findById(id);
        if (productoConsulta == null) throw new DataNotFoundException("productoId: "+id+" No exite en base de datos");
        Inventario inventarioConsulta = serviceInventario.findInventarioByProdId(productoConsulta);
        if (inventarioConsulta == null) throw new DataNotFoundException("No Hay inventario del producto id "+id+". Esta registrado con el nombre: "+ productoConsulta.getNombre());
        log.info("*********EHDM***DEV***LOG******** [SOURCE] InventarioController.inventarioProducto **** Consulta el inventario del producto id "+id+". Esta registrado con el nombre: "+ productoConsulta.getNombre());
        response.put("mensaje",  "Se consulto el inventario del productoId:"+id+" cantidad de productos:"+inventarioConsulta.getCantidad());
        response.put("inventario", inventarioConsulta);
        return new  ResponseEntity< Map<String, Object>>(response, HttpStatus.OK);
    }

    /**
     *Controlador que actualiza el inventario con el producto id
     *
     * #endPoint = serverPath/inve/{id}
     *
     * @param id del producto
     * @param inventarioNewDto con la cantidad a actualizar
     * @return ResponseEntity  inventario actualizado y mensaje
     *
     */
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> ActualizaInventarioProducto(@Valid @RequestBody InventarioDTO inventarioNewDto, @PathVariable Long id) {
        Inventario inventarioResp = new Inventario();

        Map<String, Object> response = new HashMap<>();
        Producto productoActual = serviceProducto.findById(id);
        if (productoActual == null) throw new DataNotFoundException("productoId: "+id+" No exite en base de datos");
        inventarioResp = serviceInventario.inventarioProducto(inventarioNewDto,productoActual,id);
        log.info("*********EHDM***DEV***LOG******** [SOURCE] InventarioController.ActualizaInventarioProducto **** Se Actualizo el inventario del producto id "+id+" cantidad de productos:"+inventarioResp.getCantidad());
        response.put("mensaje",  "Se actualizo el inventario productoId:"+id+" cantidad de productos:"+inventarioResp.getCantidad());
        response.put("inventario", inventarioResp);
        System.out.println("*********** Actualizacion inventario producto id :"+inventarioResp.getProducto_id()+" fue exitos");
        return new ResponseEntity< Map<String, Object>>(response, HttpStatus.OK);
    }

}
