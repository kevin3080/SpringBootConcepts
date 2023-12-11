package com.firtsappspring.tutospring.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.firtsappspring.tutospring.models.Producto;

public class OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    public void saveOrder(List<Producto> products) {
       System.out.println("Guardando en la base de datos...");

       products.forEach(producto -> logger.debug("el nombre del producto: {}", producto.getNombre()));
       
    }
}
