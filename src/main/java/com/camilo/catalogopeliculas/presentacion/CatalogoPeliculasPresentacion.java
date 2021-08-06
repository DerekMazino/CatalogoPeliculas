/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camilo.catalogopeliculas.presentacion;

import com.camilo.catalogopeliculas.servicio.CatalogoPeliculasImpl;
import com.camilo.catalogopeliculas.servicio.ICatalogoPeliculas;
import java.util.Scanner;

/**
 *
 * @author camilo
 */
public class CatalogoPeliculasPresentacion {
    public static void main(String[] args) {
        var opc = -1;
        Scanner sc = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
        while(opc!=0){
            System.out.println("Elige una opcion: \n"
                    + "1. Iniciar Catalogo de Peliculas \n"
                    + "2. Agregar Pelicula \n"
                    + "3. Listar Peliculas \n"
                    + "4. Buscar Pelicula \n"
                    + "0. Salir");
            opc = Integer.parseInt(sc.nextLine());
            
            switch(opc){
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelicula: ");
                    var nombre = sc.nextLine();
                    catalogo.agregarPelicula(nombre);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Introduce una pelicula a buscar");
                    var buscar = sc.nextLine();
                    catalogo.buscarPelicula(buscar);
                    break;
                case 0:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Error intentalo de nuevo");
                    break;
            }
        }
    }
}
