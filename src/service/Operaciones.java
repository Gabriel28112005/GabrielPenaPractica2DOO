package service;

import models.*;

import java.util.ArrayList;

public class Operaciones {
    public ArrayList<Dispositivo> listaArticulos = new ArrayList<>();
    public ArrayList<Marca> listaMarcas = new ArrayList<>();


    public void agregarMarca(String nombreMarca, String paisMarca, int facturacionMarca){
        Marca marca = new Marca(nombreMarca, paisMarca, facturacionMarca);
        listaMarcas.add(marca);
    }


    public void agregarTelevisor(double precioTelevisor, Marca marcaTelevisor, String nombreTelevisor, TipoPantalla tipoPantallaTelevisor, int tamanoPulgadasTelevisor){
        Televisor televisor = new Televisor(precioTelevisor, marcaTelevisor, nombreTelevisor, tipoPantallaTelevisor, tamanoPulgadasTelevisor);
        listaArticulos.add(televisor);
    }

    public void agregarMovil(double precioMovil, Marca marcaMovil, String nombreMovil, TipoSistemaOperativo tipoSistemaOperativoMovil, int tamanoRamMovil){
        Movil movil = new Movil(precioMovil, marcaMovil, nombreMovil, tipoSistemaOperativoMovil, tamanoRamMovil);
        listaArticulos.add(movil);
    }

    public void mostrarMarcas(ArrayList<Marca> listaMarcas){
        for (Marca marca : listaMarcas) {
            System.out.println(marca.toString());
        }
    }
    public void mostrarDispositivos(ArrayList<Dispositivo> ListaArticulos){
        for (Dispositivo dispositivo : ListaArticulos) {
            System.out.println("Nombre: " + dispositivo.getNombre() + "\n Marca: " + dispositivo.getMarca().getNombre() + "\n Precio: " + dispositivo.getPrecio() + "\n");
        }
    }




} //Fin de la clase Operaciones
