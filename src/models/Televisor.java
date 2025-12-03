package models;

public class Televisor extends Dispositivo{
    private final TipoPantalla tipoPantalla;
    private final int tamanoPulgadas;

    public Televisor(double precio, Marca marca, String nombre, TipoPantalla tipoPantalla, int tamanoPulgadas) {
        super(precio, marca, nombre);
        this.tipoPantalla = tipoPantalla;
        this.tamanoPulgadas = tamanoPulgadas;
    }

    public TipoPantalla getTipoPantalla() {
        return tipoPantalla;
    }

    public int getTamanoPulgadas() {
        return tamanoPulgadas;
    }

    @Override
    public String toString() {
        return "Movil{\n" +
                " Marca: " + getMarca() + "\n" +
                " Nombre: " + getNombre() + "\n" +
                " Precio: " + getPrecio() + "€\n" +
                " Tipo de pantalla: " + getTipoPantalla() + "\n" +
                " Tamaño de pulgadas: " + getTamanoPulgadas() + "\n" +
                '}';
    }


} //Fin de la clase Televisor
