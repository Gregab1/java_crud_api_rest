package com.gabyrest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabyrest.apirest.Entities.Producto;

public interface IproductoRepositorie  extends JpaRepository<Producto,Long>{

}
