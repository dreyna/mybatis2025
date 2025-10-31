package com.example.mybatis;

import com.example.mybatis.entity.Producto;
import com.example.mybatis.mappers.ProductoMapper;
import com.example.mybatis.serviceImpl.ProductoServiceImpl;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MybatisApplicationTests {

    @Mock
    private ProductoMapper productoMapper;

    @InjectMocks
    private ProductoServiceImpl productoService;

    @Test
    void testGuardarProducto() {
        Producto producto = new Producto(0, "Laptop1", 3700.0, 5);
        when(productoMapper.save(producto)).thenReturn(1);

        int resultado = productoService.save(producto);

        assertEquals(1, resultado);
        verify(productoMapper).save(producto);
    }

    @Test
    void testBuscarProductoPorId() {
        Producto producto = new Producto(1, "Teclado", 100.0, 10);
        when(productoMapper.findById(1)).thenReturn(producto);

        Producto resultado = productoService.findById(1);

        assertNotNull(resultado);
        assertEquals("Teclado", resultado.getNombre());
        verify(productoMapper).findById(1);
    }

    @Test
    void testListarProductos() {
        List<Producto> productos = Arrays.asList(
                new Producto(1, "Mouse", 50.0, 20),
                new Producto(2, "Monitor", 700.0, 8)
        );
        when(productoMapper.findAll()).thenReturn(productos);

        List<Producto> resultado = productoService.findAll();

        assertEquals(2, resultado.size());
        verify(productoMapper).findAll();
    }

    @Test
    void testActualizarProducto() {
        Producto producto = new Producto(5, "Mouse", 60.0, 15);
        when(productoMapper.update(producto)).thenReturn(1);

        int resultado = productoMapper.update(producto);

        assertEquals(1, resultado);
        verify(productoMapper).update(producto);
    }

    @Test
    void testEliminarProducto() {
        when(productoMapper.deleteById(1)).thenReturn(1);

        int resultado = productoService.deleteBydId(1);

        assertEquals(1, resultado);
        verify(productoMapper).deleteById(1);
    }
}
