package Lab09act06;

public class Persona {
    protected String nif;
    protected String nombre;
    protected int edad;

    public Persona(String nif, String nombre, int edad){
        this.nombre=nombre;
        this.nif=nif;
        this.edad=edad;
    }
    public String getNombre(){
        return nombre;
    }
    public String toString(){
        return this.nombre+"\t"+this.nif+"\t"+this.edad+"\n";
    }
}
