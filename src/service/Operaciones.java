package service;

import exceptions.ExcepcionBuscarMovil;
import exceptions.ExcepcionBuscarTelevisor;
import models.*;

import java.util.ArrayList;
import java.util.Comparator;

public class Operaciones {
    public ArrayList<Dispositivo> listaArticulos = new ArrayList<>();
    public ArrayList<Marca> listaMarcas = new ArrayList<>();

    public void agregarMarca(String nombreMarca, String paisMarca, int facturacionMarca){
        Marca marca = new Marca(nombreMarca, paisMarca, facturacionMarca);
        listaMarcas.add(marca);
        System.out.print("La marca ha sido agregada correctamente.\n");
    }

    public void agregarTelevisor(double precioTelevisor, Marca marcaTelevisor, String nombreTelevisor, TipoPantalla tipoPantallaTelevisor, int tamanoPulgadasTelevisor){
        Televisor televisor = new Televisor(precioTelevisor, marcaTelevisor, nombreTelevisor, tipoPantallaTelevisor, tamanoPulgadasTelevisor);
        listaArticulos.add(televisor);
        System.out.print("El televisor ha sido agregado correctamente.\n");
    }

    public void agregarMovil(double precioMovil, Marca marcaMovil, String nombreMovil, TipoSistemaOperativo tipoSistemaOperativoMovil, int tamanoRamMovil){
        Movil movil = new Movil(precioMovil, marcaMovil, nombreMovil, tipoSistemaOperativoMovil, tamanoRamMovil);
        listaArticulos.add(movil);
        System.out.print("El móvil ha sido agregado correctamente.\n");
    }

    public void busquedaMarca(String nombreMarcaBuscar, String paisMarcaBuscar){
        Marca marcaBuscada = listaMarcas.stream()
                .filter(marca -> marca.getNombre().equals(nombreMarcaBuscar) && marca.getPais().equals(paisMarcaBuscar))
                .findFirst()
                .orElse(null);
        System.out.print("Marca encontrada:\n" + marcaBuscada + "\n");
    }

    public void encontrarTelevisor(double precioTelevisorBuscar, Marca marcaTelevisorBuscar, String nombreTelevisorBuscar, TipoPantalla tipoPantallaTelevisorBuscar, int tamanoPulgadasTelevisorBuscar) throws ExcepcionBuscarTelevisor {
        Televisor televisorBuscado = listaArticulos.stream()
                .filter(articulo -> articulo instanceof Televisor)
                .map(articulo -> (Televisor) articulo)
                .filter(televisor -> televisor.getPrecio() == precioTelevisorBuscar &&
                        televisor.getMarca().equals(marcaTelevisorBuscar) &&
                        televisor.getNombre().equals(nombreTelevisorBuscar) &&
                        televisor.getTipoPantalla() == tipoPantallaTelevisorBuscar &&
                        televisor.getTamanoPulgadas() == tamanoPulgadasTelevisorBuscar)
                .findFirst()
                .orElse(null);

        if(televisorBuscado != null){
            System.out.print("Televisor encontrado:\n" + televisorBuscado + "\n");
        } else{
            throw new ExcepcionBuscarTelevisor("El televisor ingresado no está registrado. Volviendo al menú...\n");
        }
    }

    public void busquedaMovil(double precioMovilBuscar, Marca marcaMovilBuscar, String nombreMovilBuscar, TipoSistemaOperativo tipoSistemaOperativoMovilBuscar, int tamanoRamMovilBuscar) throws ExcepcionBuscarMovil {
        Movil movilBuscado = new Movil(precioMovilBuscar, marcaMovilBuscar, nombreMovilBuscar, tipoSistemaOperativoMovilBuscar, tamanoRamMovilBuscar);

        if(listaArticulos.contains(movilBuscado)){
            System.out.print("Móvil encontrado:\n" + movilBuscado + "\n");
        } else{
            throw new ExcepcionBuscarMovil("El móvil ingresado no está registrado. Volviendo al menú...\n");
        }

    }

    public void mostrarMarcas(){
        listaMarcas.sort(Comparator.comparing(Marca::getFacturacion).reversed()); //Ordenar listaMarcas por facturación de forma descendente
        System.out.println("Listado de marcas registradas:\n");
        listaMarcas.stream().forEach(marca -> System.out.print(marca + "\n"));
    }

    public void mostrarArticulos(){
        listaArticulos.sort(Comparator.comparing(Dispositivo::getPrecio).reversed()); //Ordenar listaArticulos por precio de forma ascendente
        System.out.print("Listado de artículos registrados:\n");
        listaArticulos.stream().forEach(articulo -> System.out.print(articulo + "\n"));
    }

} //Fin de la clase Operaciones
