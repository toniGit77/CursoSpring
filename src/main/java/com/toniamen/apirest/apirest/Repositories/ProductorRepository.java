package com.toniamen.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toniamen.apirest.apirest.Entities.Producto;

public interface ProductorRepository extends JpaRepository<Producto, Long>{

}
