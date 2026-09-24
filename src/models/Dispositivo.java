package models;
import java.util.Objects;

public abstract class Dispositivo {
    protected double precio;
    protected Marca marca;
    protected String nombre;

    public Dispositivo(double precio, Marca marca, String nombre){
        this.precio = precio;
        this.marca = marca;
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public Marca getMarca() {
        return marca;
    }

    //Dos dispositivos son iguales si son del mismo tipo y tienen el mismo precio, la misma marca y el mismo nombre
    @Override
    public boolean equals(Object objeto){
        if(this == objeto){
            return true;
        }
        if(objeto == null || getClass() != objeto.getClass()){
            return false;
        }
        Dispositivo dispositivo = (Dispositivo) objeto;
        return Double.compare(precio, dispositivo.precio) == 0 &&
                Objects.equals(marca, dispositivo.marca) &&
                Objects.equals(nombre, dispositivo.nombre);
    }

    @Override
    public int hashCode(){
        return Objects.hash(precio, marca, nombre);
    }

} //Fin de la clase Dispositivo