package models;
import java.util.Objects;

public class Movil extends Dispositivo {
    private final TipoSistemaOperativo sistemaOperativo;
    private final int tamanoRAM;

    public Movil(double precio, Marca marca, String nombre, TipoSistemaOperativo sistemaOperativo, int tamanoRAM) {
        super(precio, marca, nombre);
        this.sistemaOperativo = sistemaOperativo;
        this.tamanoRAM = tamanoRAM;
    }

    public TipoSistemaOperativo getSistemaOperativo() {
        return sistemaOperativo;
    }

    public int getTamanoRAM() {
        return tamanoRAM;
    }

    //Dos móviles son iguales si son dispositivos iguales y tienen el mismo sistema operativo y el mismo tamaño de RAM
    @Override
    public boolean equals(Object objeto){
        if(!super.equals(objeto)){
            return false;
        }
        Movil movil = (Movil) objeto;
        return sistemaOperativo == movil.sistemaOperativo && tamanoRAM == movil.tamanoRAM;
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), sistemaOperativo, tamanoRAM);
    }

    @Override
    public String toString() {
        return "Movil{\n" +
                " Marca: " + getMarca().getNombre() + "\n" +
                " Nombre: " + getNombre() + "\n" +
                " Precio: " + getPrecio() + "€\n" +
                " Sistema operativo: " + getSistemaOperativo() + "\n" +
                " Tamaño de la RAM: " + getTamanoRAM() + "\n" +
                '}';
    }
} //Fin de la clase Movil