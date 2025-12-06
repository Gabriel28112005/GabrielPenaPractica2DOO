package models;

public class Marca {
    protected String nombre, pais;
    protected int facturacion;

    public Marca (String nombre, String pais, int facturacion){
        this.nombre = nombre;
        this.pais = pais;
        this.facturacion = facturacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public int getFacturacion() {
        return facturacion;
    }



    @Override
    public String toString(){
        return  "Marca: " + getNombre() + "\n " +
                "Pais: " + getPais() + "\n" +
                "Facturacion: " + getFacturacion();
    }



} //Fin de la clase Marca