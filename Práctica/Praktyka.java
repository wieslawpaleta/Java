//Java w3schools
//Introducción
/*Java Syntax, Statements, Syntax Code Challenge, Output/Print, Output Numbers, Output Code Challenge, Comments, Variables, Print Variables, Declare Multiple Variables, identifiers, constants (final), Variables - Ejemplos, Variables code desafío, Tipos de datos, Numeros, Boolean Data Types, Characters, Data Types Examples */
/*Recuerda que el nombre de la clase es el nombre del archivo*/
public class Praktyka {
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
//Calculador del rectángulo
        int longitud = 4;
        int ancho = 6;
        int área;
        área = longitud * ancho;
        System.out.println("La longitud es: " + longitud);
        System.out.println("La ancho es: " + ancho);
        System.out.println("La área es: " + área);        
     
        byte miByte = -128;
        short miCorto = 32767;
        long miLargo = 9223372036854775807L;
        System.out.println(miByte + miCorto + miLargo);
       
        double miDoble = 7.89346d;
        float f1 = 35e3f;
        double d1 = 12E4d;
        System.out.println(f1);
        System.out.println(d1);
        System.out.println(miDoble);
         boolean falsedad = false;
         System.out.println(falsedad);
         char miAscii = 65;
         System.out.println(miAscii);
         int artículos = 60;
         float costoPorArtículo = 12.99f;
         float costoTotal = artículos * costoPorArtículo;
         char moneda = '€';
   
System.out.println("El número de artículos: " + artículos);
System.out.println("El costo por artículo: " + costoPorArtículo + moneda);
System.out.println("El costo total = " + costoTotal + moneda);
/* Non-Primitivos tipos de datos, var palabra clave, desafío de código de tipos de datos, fundición de tipos, operadores*/
        var pe = 5;
        System.out.println(pe);
/*        ArrayList<String> coches = new Arraylist<String>();
        var coches = new ArrayList<String>();*/
       
/*Widening Casting (automáticamente)
        int miInti = 8;
        double miDoblee = miInti;
        System.out.println(miInti);
        System.out.println(miDoblee);
Narrowing Casting (manualmente)
        double miDoblee1 = 9.78d;
        int miInti1 = (int) miDoblee1;
        System.out.println(miDoblee1);
        System.out.println(miInti1);*/
//un ejemplo práctico
        int maxPuntos = 500;
        int usuarioPuntos = 423;
        double porcentaje = (double) usuarioPuntos / maxPuntos * 100.0d;
        System.out.println("El porcentaje del usuario es " + porcentaje);
        int suma4 = 100 + 50;
        int suma5 = suma4 + 250;
        int suma6 = suma5 + suma5;
        System.out.println(suma6);
/* operadores aritméticos */    
        System.out.println(g + u);
        System.out.println(g - u);
        System.out.println(g * u);
        System.out.println(g / u);
        System.out.println(g % u);
        ++g;
        System.out.println(g);
        --g;
        System.out.println(g);
        int ao = 10;
        int bo = 3;
        System.out.println(ao / bo);
        double co = 10.0d;
        double eo = 3.0d;
        System.out.println(co / eo);
//un ejemplo práctico
        int genteEnHabitación = 0;
        genteEnHabitación++;
        genteEnHabitación++;
        genteEnHabitación++;
        System.out.println(genteEnHabitación);
        genteEnHabitación--;
        System.out.println(genteEnHabitación);
/* Assignment Operators */
        int fo = 10;
        fo += 5;
        fo -= 5;
        fo *= 5;
        fo /= 5;
        fo %= 5;
        fo &= 5;
        fo |= 5;
        fo ^= 5;
        fo >>= 5;
        fo <<= 5;
        System.out.println(fo);
// un ejemplo práctico
        int ahorros = 100;
        ahorros += 50;
        System.out.println("Ahorros totales: " + ahorros);
// Operadores de comparación
        int go = 5;
        int ho = 3;
        System.out.println(go == ho);
        System.out.println(go != ho);
        System.out.println(go > ho);
        System.out.println(go < ho);
        System.out.println(go >= ho);
        System.out.println(go <= ho);
// un ejemplo práctico
        int edad1 = 18;
        System.out.println(edad1 >= 18);
        System.out.println(edad1 < 18);
// un otro ejemplo práctico
        int longitudDeLaContraseña = 5;
        System.out.println(longitudDeLaContraseña >= 8);
        System.out.println(longitudDeLaContraseña < 8);
// operadores lógicos
// un ejemplo práctico
        boolean haIniciadoSesión = true;
        boolean esAdministrador = false;
        System.out.println("Usuario habitual: " + (haIniciadoSesión && !esAdministrador));
        System.out.println("Tiene acceso: " + (haIniciadoSesión || esAdministrador));
        System.out.println("No ha iniciado sesión: " + (!haIniciadoSesión));
// Prioridad de la operadora
     
        int resultado2 = 2 + 3 * 4;
        int resultado3 = (2 + 3) * 4;
        System.out.println(resultado2);
        System.out.println(resultado3);
   
        int resultado4 = 10 - 2 + 5;
        int resultado5 = 10 - (2 + 5);
        System.out.println(resultado4);
        System.out.println(resultado5);
//desafío de código de operadores
//Strings
        String texto0 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println("La longitud del texto string es: " + texto0.length());
        String texto1 = "¡Hola el mundo!";
        String texto2 = "Buenos días ";
        String texto3 = "Hola";
        String texto4 = "Hola";
        String texto5 = "   ¡Hola todo el mundo!   ";
        System.out.println(texto1.toUpperCase());
        System.out.println(texto1.toLowerCase());
        System.out.println(texto1.indexOf("el"));
        System.out.println(texto1.charAt(0));
        System.out.println(texto1.equals(texto2));
        System.out.println(texto3.equals(texto4));
        System.out.println("Antes: [" + texto5 + "]");
        System.out.println("Después:  [" + texto5.trim() + "]");
//String concatenación
        String tuNombre = "Juan";
        String tuApellido = "Rodriguez";
        String tuSegundoNombre = "Marco";
        String tuResultado = tuNombre.concat(tuSegundoNombre).concat(tuApellido);
        System.out.println(tuNombre.concat(tuApellido));
        System.out.println(tuResultado);
//String/Numeros y Strings
        String za = "10";
        String ya = "20";
        String xa = za + ya;
        String wa = za + edad1;
        System.out.println(xa + wa);
//String/caracteres especiales
        String texto90 = "Somos\\ los\t\b\r\f llamados \"vikingos\" del n\'orte.";
        System.out.println(texto90);
// String/ eñ desafío de código de Strings
// Math
        System.out.println(Math.max(5, 6));
        System.out.println(Math.min(5, 10));
        System.out.println(Math.sqrt(64));
        System.out.println(Math.abs(-4.7));
        System.out.println(Math.pow(2, 8));
        System.out.println(Math.round(9.7));
        System.out.println(Math.ceil(6.1));
        System.out.println(Math.floor(4.9));
        System.out.println(Math.random());
        int númeroalestorio = (int) (Math.random() * 101);
        System.out.println(númeroalestorio);
// Booleans, Booleans/Booleans Ejemplos,
// Booleans/desafío de código de Booleans
        int miEdad4 = 25;
        int edadParaVotar = 18;
        //System.out.println(miEdad4 >= edadParaVotar);
        if (miEdad4 >= edadParaVotar) {
          System.out.println("Puedes votar!");
        } else {
          System.out.println("No puedes votar!");
}








//If…Else/if, If…Else/else/ If…Else/Else if
        int laClima = 2;
        if (laClima == 1) {
        System.out.println("Lleva un paraguas");
} else if (laClima == 2) {
        System.out.println("Usa gafas de sol.");
} else {
        System.out.println("Simplemente sal a la calle normalmente.");
}




        int tiempo = 13;


        if (tiempo < 14) {
        System.out.println("Buenos días.");
} else if (tiempo < 22) {
        System.out.println("Buenas tardes.");
} else {
        System.out.println("Buenas noches.");
}


//If…Else/Short Hand If...Else (Ternary Operator)
        int tiempo1 = 20;
        String resultado11 = (tiempo1 < 18) ? "Buenos días." : "Buenas tardes.";
        System.out.println(resultado11);




        int tiempo2 = 20;
        System.out.println((tiempo2 < 18) ? "Buenos días." : "Buenas tardes.");




        int tiempo3 = 22;
        String mensaje1 = (tiempo3 < 12) ? "Buenos días." : (tiempo3 < 18) ? "Buenas tardes." : "Buenas Noches.";
        System.out.println(mensaje1);




//If…Else/Nested If
        int x = 15;
        int y = 25;


        if (x > 10) {
          System.out.println("x");
}












      }
}














