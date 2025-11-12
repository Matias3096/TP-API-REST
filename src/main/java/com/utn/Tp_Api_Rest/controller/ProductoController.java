package com.utn.Tp_Api_Rest.controller;

import com.utn.Tp_Api_Rest.dto.ActualizarStockDTO;
import com.utn.Tp_Api_Rest.dto.ProductoDTO;
import com.utn.Tp_Api_Rest.dto.ProductoResponseDTO;
import com.utn.Tp_Api_Rest.exception.ProductoNotFoundException;
import com.utn.Tp_Api_Rest.model.Categoria;
import com.utn.Tp_Api_Rest.model.Producto;
import com.utn.Tp_Api_Rest.service.ProductoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
@Tag (name = "Productos", description = "Endpoints de gestión de productos")
public class ProductoController {

    private final ProductoService serv;

    @GetMapping
    public List<ProductoResponseDTO> listar() {
        return serv.obtenerTodos().stream().map(serv::toResponse).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> uno(@PathVariable Long id) {
        return serv.obtenerPorId(id)
                .map(p -> ResponseEntity.ok(serv.toResponse(p)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/categoria/{cat}")
    public List<ProductoResponseDTO> porCategoria(@PathVariable Categoria cat) {
        return serv.obtenerPorCategoria(cat).stream().map(serv::toResponse).toList();
    }

    @PostMapping
    public ResponseEntity<ProductoResponseDTO> crear(@Valid @RequestBody ProductoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serv.crearDto(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> actualizar(@PathVariable Long id,
                                                          @Valid @RequestBody ProductoDTO dto) {
        return ResponseEntity.ok(serv.actualizarDto(id, dto));
    }

    @PatchMapping("/{id}/stock")
    public ResponseEntity<ProductoResponseDTO> patchStock(@PathVariable Long id,
                                                          @Valid @RequestBody ActualizarStockDTO dto) {
        Producto p = serv.obtenerPorId(id)
                .orElseThrow(() -> new ProductoNotFoundException(id));
        Producto actualizado = serv.actualizarStock(id, dto.getStock());
        return ResponseEntity.ok(serv.toResponse(actualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id) {
        serv.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}