package com.utn.Tp_Api_Rest.dto;

import com.utn.Tp_Api_Rest.model.Categoria;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductoDTO {
    @NotBlank @Size (min = 3, max = 100)
    private String nombre;

    @Size (max = 500)
    private String descripcion;

    @NotNull @DecimalMin("0.01")
    private Double precio;

    @NotNull @Min(0)
    private Integer stock;

    @NotNull
    private Categoria categoria;
}
