//Java w3schools
//Introducción 
/*Java Syntax, Statements, Syntax Code Challenge, Output/Print, Output Numbers, Output Code Challenge, Comments, Variables, Print Variables, Declare Multiple Variables, identifiers, constants (final), Variables - Ejemplos (teraz tu jestem!)*/
/*Recuerda que el nombre de la clase es el nombre del archivo*/

public class Main {
    public static void main(String[] args) {
        String nombre = "José";
        int edad = 100;
        float puntito;
        puntito = 19.99f;
        char letra = 'm';
        boolean verdad = true;
        int miNumero = 7;
        miNumero = 8;
        System.out.println("Hola " + nombre + ", de " + edad + " años!" );
        System.out.println("Java es divertido!");
        System.out.print("Y eso es lo que me gusta!\n");
        System.out.println("dos");
        System.out.println("tres");
        System.out.println(2 * 3);
        System.out.println(puntito);
        System.out.println(letra);
        System.out.println(verdad);
        System.out.println(miNumero);
        /*final int cinco = 5;
        cinco = 6;
        System.out.println(cinco);*/
        System.out.println(miNumero + edad);
        System.out.println("La suma es " + miNumero + edad);
        System.out.println("La suma es " + (miNumero + edad));
        int g = 4;
        int u = 3;
        int t = 2;
        System.out.println(g + u + t);
        int f = 4, k = 3, j = 2;
        System.out.println(f + k + j);
        int h, o, p;
        h = o = p = 50;
        System.out.println(h + o + p);
        
        /*final 
        int VEINTISÉIS = 26;
        VEINTISÉIS = 20;
        System.out.println(VEINTISÉIS )*/
//Calculador
        int longitud = 4;
        int ancho = 6;
        int área;
        área = longitud * ancho;
        System.out.println("La longitud es: " + longitud);
        System.out.println("La ancho es: " + ancho);
        System.out.println("La área es: " + área);         
    }
}
