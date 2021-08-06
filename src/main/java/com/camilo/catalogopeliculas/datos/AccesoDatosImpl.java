/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camilo.catalogopeliculas.datos;

import com.camilo.catalogopeliculas.domain.Pelicula;
import com.camilo.catalogopeliculas.excepciones.AccesoDatosEx;
import com.camilo.catalogopeliculas.excepciones.EscrituraDatosEx;
import com.camilo.catalogopeliculas.excepciones.LecturaDatosEx;
import java.io.*;
import java.io.File;
import java.util.*;




/**
 *
 * @author camilo
 */
public class AccesoDatosImpl implements IAccesoDatos{

    @Override
    public boolean existe(String nombreRecurso) throws AccesoDatosEx {
        File archivo = new File(nombreRecurso);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {
        File archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while(linea != null){
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            throw new LecturaDatosEx("Excepción: Alistar Peliculas: "+ ex.getMessage());
        } catch (IOException ex) {
            throw new LecturaDatosEx("Excepción: Alistar Peliculas: "+ ex.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreRecurso);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito informacion en el archivo "+pelicula);
        } catch (IOException ex) {
            throw new EscrituraDatosEx("Excepción: Alistar Peliculas: "+ ex.getMessage());
        }
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
        File archivo = new File(nombreRecurso);
        String resultado = null;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = entrada.readLine();
            int indice = 1;
            while(linea!=null){
                if(buscar != null && buscar.equalsIgnoreCase(linea)){
                    resultado = "La pelicula " + linea + " encontrada en el indice "+indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
              
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            throw new LecturaDatosEx("Excepción: Alistar Peliculas: "+ ex.getMessage());
        } catch (IOException ex) {
            throw new LecturaDatosEx("Excepción: Alistar Peliculas: "+ ex.getMessage());
        }
        
        
        return resultado;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {
        File archivo = new File(nombreRecurso);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Archivo Creado");
        } catch (IOException ex) {
            throw new AccesoDatosEx("Excepción: Crear Archivo: "+ ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosEx {
        File archivo = new File(nombreRecurso);
        if(archivo.exists())
            archivo.delete();
        System.out.println("Se ha borrado el archivo");
    }
    
}
