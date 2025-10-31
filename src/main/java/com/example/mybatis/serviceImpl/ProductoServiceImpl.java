/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mybatis.serviceImpl;

import com.example.mybatis.entity.Producto;
import com.example.mybatis.mappers.ProductoMapper;
import com.example.mybatis.service.ProductoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author REYNABARRETOBENJAMIN
 */
@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService{
    private final ProductoMapper mapper;
    @Override
    public List<Producto> findAll() {
        return mapper.findAll();
    }

    @Override
    public Producto findById(int id) {
        return mapper.findById(id);
    }

    @Override
    public int deleteBydId(int id) {
        return mapper.deleteById(id);
    }

    @Override
    public int save(Producto item) {
        return mapper.save(item);
    }
    @Override
    public int update(int id, Producto item) {
        item.setId(id);
        Producto p = mapper.findById(id);
        p.setCantidad(id);
        p.setNombre(item.getNombre());
        p.setPrecio(item.getPrecio());
        p.setCantidad(item.getCantidad());
        return mapper.update(p);
    }
}
