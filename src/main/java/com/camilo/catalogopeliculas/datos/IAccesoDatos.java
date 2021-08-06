/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camilo.catalogopeliculas.datos;

import com.camilo.catalogopeliculas.domain.Pelicula;
import com.camilo.catalogopeliculas.excepciones.*;

import java.util.List;

/**
 *
 * @author camilo
 */
public interface IAccesoDatos {
    
    boolean existe(String nombreRecurso) throws AccesoDatosEx;
    
    List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;
    
    void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;
    
    String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;
    
    void crear(String nombreRecurso) throws AccesoDatosEx;
    
    void borrar(String nombreRecurso) throws AccesoDatosEx;
    
}
