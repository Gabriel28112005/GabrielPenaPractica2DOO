package models;
import java.util.Objects;

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

    //Dos marcas son iguales si tienen el mismo nombre y el mismo país
    @Override
    public boolean equals(Object objeto){
        if(this == objeto){
            return true;
        }
        if(objeto == null || getClass() != objeto.getClass()){
            return false;
        }
        Marca marca = (Marca) objeto;
        return Objects.equals(nombre, marca.nombre) && Objects.equals(pais, marca.pais);
    }

    @Override
    public int hashCode(){
        return Objects.hash(nombre, pais);
    }

    @Override
    public String toString(){
        return  "\n Marca: " + getNombre() + "\n" +
                " País de la marca: " + getPais() + "\n" +
                " Facturación de la marca: " + getFacturacion() +"€";
    }



} //Fin de la clase Marca