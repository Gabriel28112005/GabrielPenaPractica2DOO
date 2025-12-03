package models;

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

} //Fin de la clase Dispositivo