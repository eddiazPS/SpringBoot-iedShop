package co.com.ied.shop.iedshop.models.service;


import co.com.ied.shop.iedshop.models.dao.ProductoRepository;

import co.com.ied.shop.iedshop.models.entity.Producto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ServiceProductoImpTest {

    @Mock
    private ProductoRepository productoRepository;

    @Autowired
    ServiceProductoImp serviceProductoImp;

    @Nested
    @DisplayName("Pruebas Inventario ")
    class ProductoTest {



        @Test
        @DisplayName(" Consulta inventario por id ")
        void findByIdTest() {
            //given
            Producto p = new Producto(1L,"DvD",new BigDecimal(9000));
            Long productoid = 1L;
            when(productoRepository.findById(productoid)).thenReturn(Optional.of(p));
            //when
            Producto productoServicio = serviceProductoImp.findById(productoid);
            //Then
            assertEquals(p.getId(), productoServicio.getId());

        }
        @Test
        @DisplayName("Consulta inventario por producto id  ")
        void findallTest() {

            //given
            Producto p1 = new Producto(1L,"DvD",new BigDecimal(9000));
            Producto p2 = new Producto(1L,"DvD",new BigDecimal(9000));
            Producto p3 = new Producto(1L,"DvD",new BigDecimal(9000));

            Long productoid = 1L;

            List<Producto> lp = Arrays.asList(p1,p2,p3);
            when(productoRepository.findAll()).thenReturn(lp);
            //when
            List <Producto> ListaProductoServicio = serviceProductoImp.findall();
            //Then
            assertEquals(lp.get(0).getId(), ListaProductoServicio.get(0).getId());
        }
    }

}
