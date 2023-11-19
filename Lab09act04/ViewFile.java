package Lab09act04;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ViewFile extends JFrame{
    private JTextArea areaTexto;

    // Constructor que toma una cadena como parámetro
    public ViewFile(String s){
        // Llama al constructor de la superclase con el título de la ventana
        super("Mostrando el contenido de un archivo");
        // Crea un nuevo JTextArea con el contenido del archivo
        areaTexto=new JTextArea(s,5,40);
        // Añade el JTextArea a la ventana
        add(areaTexto);
    }
}