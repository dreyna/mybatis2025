/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.mybatis.service;

import com.example.mybatis.entity.Producto;
import java.util.List;

/**
 *
 * @author REYNABARRETOBENJAMIN
 */
public interface ProductoService {
    List<Producto> findAll();
    Producto findById(int id);
    int deleteBydId(int id);
    int save(Producto item);
    int update(int id, Producto item);
}
