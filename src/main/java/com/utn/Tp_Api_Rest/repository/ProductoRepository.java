package com.utn.Tp_Api_Rest.repository;

import com.utn.Tp_Api_Rest.model.Categoria;
import com.utn.Tp_Api_Rest.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByCategoria(Categoria categoria);
}
