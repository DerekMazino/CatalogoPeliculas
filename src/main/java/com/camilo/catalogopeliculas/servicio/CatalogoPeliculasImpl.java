/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camilo.catalogopeliculas.servicio;

import com.camilo.catalogopeliculas.datos.AccesoDatosImpl;
import com.camilo.catalogopeliculas.datos.IAccesoDatos;
import com.camilo.catalogopeliculas.domain.Pelicula;
import com.camilo.catalogopeliculas.excepciones.AccesoDatosEx;
import com.camilo.catalogopeliculas.excepciones.LecturaDatosEx;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author camilo
 */
public class CatalogoPeliculasImpl implements ICatalogoPeliculas{
    
    private final IAccesoDatos datos;
    
    public CatalogoPeliculasImpl(){
        this.datos = new AccesoDatosImpl();
    }
    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de Acceso a Datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            List peliculas = this.datos.listar(NOMBRE_RECURSO);
            for(var peli: peliculas){
                System.out.println("Pelicula: "+ peli);
            }
        } catch (LecturaDatosEx ex) {
            System.out.println("Error Acceso a Datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de Acceso a Datos");
            ex.printStackTrace(System.out);
        }
        System.out.println("Resultado: "+resultado);
        
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if(this.datos.existe(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }else{
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar catalogo de peliculas");
            ex.printStackTrace(System.out);
        }
    }
    
}
