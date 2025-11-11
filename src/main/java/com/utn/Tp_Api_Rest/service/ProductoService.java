package com.utn.Tp_Api_Rest.service;

import com.utn.Tp_Api_Rest.dto.ProductoDTO;
import com.utn.Tp_Api_Rest.dto.ProductoResponseDTO;
import com.utn.Tp_Api_Rest.model.Categoria;
import com.utn.Tp_Api_Rest.model.Producto;
import com.utn.Tp_Api_Rest.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ProductoService {
    private final ProductoRepository repo;

    public List<Producto> obtenerTodos() {
        return repo.findAll();
    }
    public Optional<Producto> obtenerPorId(Long id) {
        return repo.findById(id);
    }
    public List<Producto> obtenerPorCategoria(Categoria categoria) {
        return repo.findByCategoria(categoria);
    }

    public Producto crear(Producto p){
        return repo.save(p);
    }
    public Producto actualizar(Long id, Producto p){
        p.setId(id); //aca nos aseguramos que sobreescribe
        return repo.save(p);
    }

    public void eliminar(Long id){
        repo.deleteById(id);
    }

    public Producto actualizarStock(Long id, Integer stock){
        Producto p = repo.findById(id).orElseThrow();
        p.setStock(stock);
        return repo.save(p);
    }

    public ProductoResponseDTO toResponse( Producto p){
        return ProductoResponseDTO.builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .descripcion(p.getDescripcion())
                .precio(p.getPrecio())
                .stock(p.getStock())
                .categoria(p.getCategoria())
                .build();
    }

    public ProductoResponseDTO crearDto(ProductoDTO dto) {
        Producto p = Producto.builder()
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .precio(dto.getPrecio())
                .stock(dto.getStock())
                .categoria(dto.getCategoria())
                .build();
        return toResponse(repo.save(p));
    }

    public ProductoResponseDTO actualizarDto(Long id, ProductoDTO dto) {
        Producto p = repo.findById(id).orElseThrow();
        p.setNombre(dto.getNombre());
        p.setDescripcion(dto.getDescripcion());
        p.setPrecio(dto.getPrecio());
        p.setStock(dto.getStock());
        p.setCategoria(dto.getCategoria());
        return toResponse(repo.save(p));
    }
}