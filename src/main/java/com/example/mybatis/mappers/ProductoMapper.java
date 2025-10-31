/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.mybatis.mappers;

import com.example.mybatis.entity.Producto;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 *
 * @author REYNABARRETOBENJAMIN
 */
@Mapper
public interface ProductoMapper {
    @Select("SELECT * FROM producto")
    List<Producto> findAll();

    @Select("SELECT * FROM producto WHERE id = #{id}")
    Producto findById(@Param("id") int id);

    @Delete("DELETE FROM producto WHERE id = #{id}")
    int deleteById(@Param("id") int id);

    @Insert("INSERT INTO producto(id, nombre, precio, cantidad) VALUES (#{id}, #{nombre}, #{precio}, #{cantidad})")
    int save(Producto item);

    @Update("UPDATE producto SET nombre=#{nombre}, precio=#{precio}, cantidad=#{cantidad} WHERE id=#{id}")
    int update(Producto item);
}
