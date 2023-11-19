package Lab09act02;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String cadena;

        // Intenta crear un nuevo PrintWriter que escribe en el archivo especificado
        try(PrintWriter salida=new PrintWriter("C:\\universidad\\LPIII\\Lab09act02\\texto.txt")){
            // Solicita al usuario que introduzca texto
            System.out.println("Introduce texto. Para acabar introduce la cadena FIN");
            cadena=sc.nextLine();

            // Mientras la cadena introducida no sea "FIN", sigue escribiendo en el archivo
            while(!cadena.equalsIgnoreCase("FIN")){
                salida.println(cadena);
                cadena=sc.nextLine();
            }
        }
        // Captura y maneja la excepción si el archivo no se encuentra
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
