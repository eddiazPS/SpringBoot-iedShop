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
     * Consulta el inventario de un producto específico por el ID de un producto.
     *
     * <p>Este endpoint busca el producto por su identificador en la base de datos.
     * Si el producto no existe, lanza una excepción {@link DataNotFoundException}.
     * Si el producto existe pero no tiene inventario registrado, también lanza una excepción.
     * En caso exitoso, retorna un objeto con el mensaje y el inventario encontrado.</p>
     *
     * @param id el ID del producto a consultar.
     * @return una respuesta HTTP con un mapa que contiene un mensaje descriptivo y
     *         el objeto {@link Inventario} correspondiente.
     * @throws DataNotFoundException si el producto o su inventario no se encuentra en la base de datos.
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
     * Controlador que actualiza el inventario de un producto específico.
     *
     * Este endpoint recibe el ID de un producto y la nueva cantidad de inventario a actualizar.
     * Si el producto no existe, lanza una excepción `DataNotFoundException`.
     *
     * ### Endpoint
     * `POST /inve/{id}`
     *
     * @param id El ID del producto cuyo inventario se actualizará.
     * @param inventarioNewDto Objeto que contiene la nueva cantidad del producto en inventario.
     * @return ResponseEntity con un mapa que contiene el mensaje de éxito y los detalles del inventario actualizado.
     *
     * ### Respuesta
     * - `mensaje`: Mensaje indicando que el inventario ha sido actualizado con éxito.
     * - `inventario`: El inventario actualizado con la nueva cantidad.
     *
     * @throws DataNotFoundException Si el producto con el ID especificado no existe en la base de datos.
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
