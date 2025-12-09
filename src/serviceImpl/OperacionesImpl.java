package serviceImpl;

import exceptions.ExcepcionBuscarMovil;
import exceptions.ExcepcionBuscarTelevisor;
import models.*;
import service.Operaciones;

import java.util.ArrayList;
import java.util.Comparator;

public class OperacionesImpl implements Operaciones {
    public ArrayList<Dispositivo> listaArticulos = new ArrayList<>();
    public ArrayList<Marca> listaMarcas = new ArrayList<>();

    public ArrayList<Dispositivo> getListaArticulos(){
        return listaArticulos;
    }

    public ArrayList<Marca> getListaMarcas(){
        return listaMarcas;
    }

    public void agregarMarca(String nombreMarca, String paisMarca, int facturacionMarca){
        Marca marca = new Marca(nombreMarca, paisMarca, facturacionMarca);
        listaMarcas.add(marca);
        System.out.println("\nLa marca ha sido agregada correctamente. Volviendo al menú...\n");
    }

    public void agregarTelevisor(double precioTelevisor, Marca marcaTelevisor, String nombreTelevisor, TipoPantalla tipoPantallaTelevisor, int tamanoPulgadasTelevisor){
        Televisor televisor = new Televisor(precioTelevisor, marcaTelevisor, nombreTelevisor, tipoPantallaTelevisor, tamanoPulgadasTelevisor);
        listaArticulos.add(televisor);
        System.out.println("\nEl televisor ha sido agregado correctamente. Volviendo al menú...\n");
    }

    public void agregarMovil(double precioMovil, Marca marcaMovil, String nombreMovil, TipoSistemaOperativo tipoSistemaOperativoMovil, int tamanoRamMovil){
        Movil movil = new Movil(precioMovil, marcaMovil, nombreMovil, tipoSistemaOperativoMovil, tamanoRamMovil);
        listaArticulos.add(movil);
        System.out.println("\nEl móvil ha sido agregado correctamente. Volviendo al menú...\n");
    }

    public void busquedaMarca(String nombreMarcaBuscar, String paisMarcaBuscar){
        Marca marcaBuscada = listaMarcas.stream()
                .filter(marca -> marca.getNombre().equals(nombreMarcaBuscar) && marca.getPais().equals(paisMarcaBuscar))
                .findFirst()
                .orElse(null);
        System.out.println("\nMarca encontrada:\n" + marcaBuscada + "\nVolviendo al ménu...\n\n");
    }

    // Buscar televisor por todos sus atributos
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
            System.out.println("\nTelevisor encontrado:\n" + televisorBuscado + "\n");
        } else{
            throw new ExcepcionBuscarTelevisor("El televisor ingresado no está registrado. Volviendo al menú...\n\n");
        }
    }

    public void busquedaMovil(double precioMovilBuscar, Marca marcaMovilBuscar, String nombreMovilBuscar, TipoSistemaOperativo tipoSistemaOperativoMovilBuscar, int tamanoRamMovilBuscar) throws ExcepcionBuscarMovil {
        Movil movilBuscado = new Movil(precioMovilBuscar, marcaMovilBuscar, nombreMovilBuscar, tipoSistemaOperativoMovilBuscar, tamanoRamMovilBuscar);

        if(listaArticulos.contains(movilBuscado)){
            System.out.println("\nMóvil encontrado:\n" + movilBuscado + "\n");
        } else{
            throw new ExcepcionBuscarMovil("el móvil ingresado no está registrado. Volviendo al menú...\n\n");
        }

    }

    public void mostrarMarcas(){
        listaMarcas.sort(Comparator.comparing(Marca::getFacturacion).reversed()); //Ordenar listaMarcas por facturación de forma descendente
        System.out.println("\nListado de marcas registradas:");
        listaMarcas.stream().forEach(marca -> System.out.println(marca));
        System.out.print("\nVolviendo al menú...\n\n");
    }

    public void mostrarArticulos(){
        listaArticulos.sort(Comparator
                .comparing((Dispositivo dispositivo) -> dispositivo.getMarca().getNombre())
                .thenComparing(Dispositivo::getPrecio)
                .thenComparing(Dispositivo::getNombre)); //Ordenar listaArticulos por precio de forma ascendente
        System.out.println("\nListado de artículos registrados:");
        listaArticulos.stream().forEach(articulo -> System.out.println(articulo));
        System.out.print("\nVolviendo al menú...\n\n");
    }

} //Fin de la clase Operaciones
