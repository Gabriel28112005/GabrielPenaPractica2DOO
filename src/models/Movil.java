package models;

public class Movil extends Dispositivo {
    private TipoSistemaOperativo sistemaOperativo;
    private int tamanoRAM;

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

    public Marca getMarca(){
        return marca;
    }

    @Override
    public String toString() {
        return "Movil{\n" +
                " Marca: " + getMarca() + "\n" +
                " Nombre: " + getNombre() + "\n" +
                " Precio: " + getPrecio() + "€\n" +
                " Sistema operativo: " + getSistemaOperativo() + "\n" +
                " Tamaño de la RAM: " + getTamanoRAM() + "\n" +
                '}';
    }
} //Fin de la clase Movil
