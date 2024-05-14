//Bibliotecas
import java.io.*;               //Liberia para uso, lectura y escritura en archivos
import java.util.ArrayList;     //Liberia para uso de Arrays y ArrayList
import java.util.Scanner;       //Librerai para uso del Scanner

//Clase Abstracta Libro
abstract class Libro {
    private String titulo;
    private String autor;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    // Método abstracto para calcular el precio del libro
    public abstract double calcularPrecio();
}


public class Main {
    public static void main(String[] args) {

    }
}
