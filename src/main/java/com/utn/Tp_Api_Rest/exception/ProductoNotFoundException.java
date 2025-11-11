package com.utn.Tp_Api_Rest.exception;

public class ProductoNotFoundException extends RuntimeException {
    public ProductoNotFoundException(Long id) {
        super("Producto con id " + id + " no encontrado");
    }
}
