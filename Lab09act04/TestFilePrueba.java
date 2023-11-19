package Lab09act04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;

public class TestFilePrueba {
    public static void main(String[] args) throws IOException{
        FileInputStream file;
        byte b[]=new byte[1024];

        // Intenta leer un archivo y mostrar su contenido en una ventana
        try{
            // Abre el archivo especificado
            file=new FileInputStream("C:\\universidad\\LPIII\\Lab09act04\\TestFilePrueba.java");
            // Lee el archivo en el array de bytes
            file.read(b);
            // Convierte el array de bytes en una cadena
            String s=new String(b);
            // Crea una nueva ventana con el contenido del archivo
            ViewFile view=new ViewFile(s);
            // Configura la operación de cierre por defecto
            view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // Configura el tamaño de la ventana
            view.setSize(400, 150);
            // Hace visible la ventana
            view.setVisible(true);
        }
        // Captura y maneja las excepciones si el archivo no se encuentra o si ocurre un error de E/S
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

