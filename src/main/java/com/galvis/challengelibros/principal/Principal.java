package com.galvis.challengelibros.principal;

import com.galvis.challengelibros.model.Datos;
import com.galvis.challengelibros.model.DatosLibros;
import com.galvis.challengelibros.model.Libro;
import com.galvis.challengelibros.repository.LibroRepository;
import com.galvis.challengelibros.service.ConsumoAPI;
import com.galvis.challengelibros.service.ConvierteDatos;

import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);
    private LibroRepository repositorio;

    public Principal(LibroRepository repository) {
        this.repositorio = repository;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar Libro 
                    2 - Listar libros registrados
                    3 - Listar Autores registrados
                    4 - Listar Autores vivos en un determinado año
                    5 - Listar libros por idioma
                                  
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroEnApiWeb();
                    break;
//                case 2:
//                    buscarEpisodioPorSerie();
//                    break;
//                case 3:
//                    mostrarSeriesBuscadas();
//                    break;
//                case 4:
//                    buscarSeriePortitulo();
//                    break;
//                case 5:
//                    buscarTop5SDeries();
//                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

//    private void buscarSerieWeb() {
//        DatosSerie datos = getDatosSerie();
//        Serie serie = new Serie(datos);
//        repositorio.save(serie);
//        //datosSeries.add(datos);
//        System.out.println(datos);
//    }
    private void buscarLibroEnApiWeb(){
        DatosLibros datos = getDatosLibros();
        Libro libro = new Libro(datos);
        repositorio.save(libro);
        System.out.println("prueba 2" + datos);
    }

    private DatosLibros getDatosLibros() {
        /*BUSQUEDA DE LIBRO POR NOMBRE*/
//        var json = consumoAPI.obtenerDatos(URL_BASE);
////        System.out.println(json);
//        DatosLibros datos = conversor.obtenerDatos(json, DatosLibros.class);
//        System.out.println(datos);
        System.out.println("Ingrese el nombre del libro que desea buscar");
        var tituloLibro = teclado.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE+"?search=" + tituloLibro.replace(" ","+"));
        DatosLibros datos = conversor.obtenerDatos(json, DatosLibros.class);
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLibros> libroBuscado = datosBusqueda.resultados().stream()
                .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();
        if(libroBuscado.isPresent()){
            System.out.println("Libro Encontrado ");
            System.out.println("prueba " + libroBuscado.get());
        }else {
            System.out.println("Libro no encontrado");
        }
        return datos;

    }

//    private DatosSerie getDatosSerie() {
//        System.out.println("Escribe el nombre de la serie que deseas buscar");
//        var nombreSerie = teclado.nextLine();
//        var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
//        //System.out.println(json);
//        DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
//        System.out.println(datos.sinopsis());
//        return datos;
//    }


}
