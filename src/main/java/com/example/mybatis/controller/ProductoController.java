/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mybatis.controller;

import com.example.mybatis.entity.Producto;
import com.example.mybatis.service.ProductoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author REYNABARRETOBENJAMIN
 */
@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService service;

    @GetMapping
    public List<Producto> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Producto findById(@PathVariable("id") int id){
        return service.findById(id);
    }

    @PostMapping
    public int save(@RequestBody Producto product){
        return service.save(product);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id")int id, @RequestBody Producto product){
        return service.update(id, product);
    }

    @DeleteMapping("/{id}")
    public int deleteById(@PathVariable("id") int id){
        return service.deleteBydId(id);
    }
}
