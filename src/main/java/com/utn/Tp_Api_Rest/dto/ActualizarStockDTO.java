package com.utn.Tp_Api_Rest.dto;

import com.utn.Tp_Api_Rest.exception.ProductoNotFoundException;
import com.utn.Tp_Api_Rest.model.Producto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ActualizarStockDTO {
    @NotNull
    @Min(0)
    private Integer stock;

    Producto p = repo.findById(id).orElseThrow(()
            -> new ProductoNotFoundException(id));

}
