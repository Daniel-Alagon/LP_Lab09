package Lab09act03;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Binarios2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        FileOutputStream fos=null;
        DataOutputStream salida=null;

        double[][] matriz;
        int filas,columnas,i,j;

        // Solicita al usuario que introduzca el número de filas y columnas
        do{
            System.out.print("Numero de filas: ");
            filas=sc.nextInt();
        }
        while(filas<=0);
        do{
            System.out.print("Numero de columnas: ");
            columnas=sc.nextInt();
        }
        while(columnas<=0);

        // Crea una matriz con las dimensiones especificadas
        matriz=new double[filas][columnas];

        // Solicita al usuario que introduzca los elementos de la matriz
        for (i=0;i<filas;i++){
            for(j=0;j<columnas;j++){
                System.out.print("matriz["+i+"]["+j+"]:");
                matriz[i][j]=sc.nextDouble();
            }
        }

        // Intenta escribir la matriz en un archivo
        try{
            fos=new FileOutputStream("C:\\universidad\\LPIII\\Lab09act03\\matriz.dat");
            salida=new DataOutputStream(fos);

            // Escribe las dimensiones de la matriz en el archivo
            salida.writeInt(filas);
            salida.writeInt(columnas);

            // Escribe los elementos de la matriz en el archivo
            for(i=0;i<filas;i++){
                for(j=0;j<columnas;j++){
                    salida.writeDouble(matriz[i][j]);
                }
            }
        }
        // Captura y maneja las excepciones si el archivo no se encuentra o si ocurre un error de E/S
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        finally{
            // Cierra los flujos de archivo
            try{
                if (fos!=null){
                    fos.close();
                }
                if(salida!=null){
                    salida.close();
                }
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
