package com.utn.Tp_Api_Rest.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarStockDTO {
    @NotNull
    @Min(0)
    private Integer stock;


}
