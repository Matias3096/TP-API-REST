package com.utn.Tp_Api_Rest;

import com.utn.Tp_Api_Rest.model.Categoria;
import com.utn.Tp_Api_Rest.model.Producto;
import com.utn.Tp_Api_Rest.service.ProductoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class TpApiRestApplication {

	public static void main(String[] args) {



        	}

    @Bean
    CommandLineRunner initData(ProductoService serv) {
        return args -> {
            serv.crear(Producto.builder()
                    .nombre("Smartphone")
                    .descripcion("Galaxy S23")
                    .precio(799.99)
                    .stock(10)
                    .categoria(Categoria.ELECTRONICA)
                    .build());
        };
    }
}
