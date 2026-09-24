package models;
import java.util.Objects;

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

    //Dos televisores son iguales si son dispositivos iguales y tienen el mismo tipo de pantalla y el mismo tamaño en pulgadas
    @Override
    public boolean equals(Object objeto){
        if(!super.equals(objeto)){
            return false;
        }
        Televisor televisor = (Televisor) objeto;
        return tipoPantalla == televisor.tipoPantalla && tamanoPulgadas == televisor.tamanoPulgadas;
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), tipoPantalla, tamanoPulgadas);
    }

    @Override
    public String toString() {
        return "Televisor{\n" +
                " Nombre: " + getNombre() + "\n" +
                " Marca: " + getMarca().getNombre() + "\n" +
                " Precio: " + getPrecio() + "€\n" +
                " Tipo de pantalla: " + getTipoPantalla() + "\n" +
                " Tamaño de pulgadas: " + getTamanoPulgadas() + "\n" +
                '}';
    }


} //Fin de la clase Televisor