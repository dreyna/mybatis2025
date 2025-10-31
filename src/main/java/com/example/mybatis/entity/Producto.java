/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author REYNABARRETOBENJAMIN
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int cantidad;
}
