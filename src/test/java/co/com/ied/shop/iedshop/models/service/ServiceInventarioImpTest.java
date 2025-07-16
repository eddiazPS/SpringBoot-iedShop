package co.com.ied.shop.iedshop.models.service;

import co.com.ied.shop.iedshop.models.DTO.InventarioDTO;
import co.com.ied.shop.iedshop.models.dao.InventarioRepository;
import co.com.ied.shop.iedshop.models.entity.Inventario;
import co.com.ied.shop.iedshop.models.entity.Producto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ServiceInventarioImpTest {

    @Mock
    private InventarioRepository inventarioRepository;

    @Autowired
    ServiceInventarioImp serviceInventarioImp;

    @Nested
    @DisplayName("Pruebas Inventario ")
    class InventarioTest {

        @Test
        @DisplayName("Con producto id actualiza cantidad en el inventario")
        void InventarioProductoTest() {
            //given
            Producto p = new Producto(3L,"DvD",new BigDecimal(9000));
            InventarioDTO idto = new InventarioDTO(33L);
            Inventario inventario = new Inventario(1L,33L,p);
            //when
            Inventario invetarioServicio =serviceInventarioImp.inventarioProducto(idto,p,3L);
            //Then
            assertEquals(inventario.getCantidad(), invetarioServicio.getCantidad());
        }

       @Test
        @DisplayName(" Consulta inventario por id ")
        void FindByProductIdTest() {
           //given
           Producto p = new Producto(1L,"DvD",new BigDecimal(9000));
           Inventario inventario = new Inventario(1L,33L,p);
           Long inventarioid = 1L;
           when(inventarioRepository.findById(inventarioid)).thenReturn(Optional.of(inventario));

           //when
           Inventario invetarioServicio =serviceInventarioImp.findByProductId(inventarioid);
           //Then
           assertEquals(inventario.getId(), invetarioServicio.getId());

        }
        @Test
        @DisplayName("Consulta inventario por producto id  ")
        void findInventarioByProdIdTest() {

            //given
            Producto p = new Producto(1L,"DvD",new BigDecimal(9000));
            Inventario inventario = new Inventario(1L,33L,p);
            Long productoid = 1L;
            when(inventarioRepository.findInventarioByProdId(p)).thenReturn(inventario);

            //when
            Inventario invetarioServicio =serviceInventarioImp.findInventarioByProdId(p);
            //Then
            assertEquals(inventario.getId(), invetarioServicio.getId());
        }
    }
}
