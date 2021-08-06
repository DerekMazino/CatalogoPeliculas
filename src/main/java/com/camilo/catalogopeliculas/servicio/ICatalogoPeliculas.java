/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camilo.catalogopeliculas.servicio;

/**
 *
 * @author camilo
 */
public interface ICatalogoPeliculas {
    
    String NOMBRE_RECURSO = "peliculas.txt";
    
    void agregarPelicula(String nombrePelicula);
    
    void listarPeliculas();
    
    void buscarPelicula(String buscar);
    
    void iniciarCatalogoPeliculas();
    
}
