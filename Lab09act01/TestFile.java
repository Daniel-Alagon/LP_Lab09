package Lab09act01;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TestFile {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);

        // Solicita al usuario que ingrese el nombre del archivo o directorio
        System.out.println("Escriba el nombre del archivo o directorio: ");

        // Crea una ruta a partir de la entrada del usuario
        Path ruta=Paths.get(sc.nextLine());

        // Verifica si la ruta existe
        if(Files.exists(ruta)){
            System.out.printf("%n%s existe%n", ruta.getFileName());
            // Verifica si la ruta es un directorio
            System.out.printf("%s un directorio%n", Files.isDirectory(ruta)?"Es":"No es");
            // Imprime la ruta absoluta
            System.out.printf("%s una ruta absoluta%n", ruta.getFileName());
            // Imprime la fecha de la última modificación
            System.out.printf("Fechha de ultima modificación: %s%n", Files.getLastModifiedTime(ruta));
            // Imprime el tamaño del archivo
            System.out.printf("Tamanio: %s%n", Files.size(ruta));
            // Imprime la ruta
            System.out.printf("Ruta: %s%n", ruta);
            // Imprime la ruta absoluta
            System.out.printf("Ruta absoluta: %s%n", ruta.toAbsolutePath());

            // Si la ruta es un directorio, imprime su contenido
            if(Files.isDirectory(ruta)){
                System.out.printf("%nContenido del directorio:%n");

                // Crea un flujo de directorio para iterar a través de su contenido
                DirectoryStream<Path> flujoDirectorio=Files.newDirectoryStream(ruta);
                
                // Imprime cada elemento en el directorio
                for(Path p:flujoDirectorio)
                    System.out.println(p);
            }   
        }
        else{
            // Si la ruta no existe, imprime un mensaje
            System.out.printf("%s no existe%n", ruta);
        }
    }
}
