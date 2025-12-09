package service;

import exceptions.ExcepcionBuscarMovil;
import exceptions.ExcepcionBuscarTelevisor;
import models.*;

import java.util.ArrayList;


public interface Operaciones {

    public ArrayList<Dispositivo> getListaArticulos();

    public ArrayList<Marca> getListaMarcas();


    public void agregarMarca(String nombreMarca, String paisMarca, int facturacionMarca);

    public void agregarTelevisor(double precioTelevisor, Marca marcaTelevisor, String nombreTelevisor, TipoPantalla tipoPantallaTelevisor, int tamanoPulgadasTelevisor);

    public void agregarMovil(double precioMovil, Marca marcaMovil, String nombreMovil, TipoSistemaOperativo tipoSistemaOperativoMovil, int tamanoRamMovil);

    public void busquedaMarca(String nombreMarcaBuscar, String paisMarcaBuscar);

    public void encontrarTelevisor(double precioTelevisorBuscar, Marca marcaTelevisorBuscar, String nombreTelevisorBuscar, TipoPantalla tipoPantallaTelevisorBuscar, int tamanoPulgadasTelevisorBuscar) throws ExcepcionBuscarTelevisor;

    public void busquedaMovil(double precioMovilBuscar, Marca marcaMovilBuscar, String nombreMovilBuscar, TipoSistemaOperativo tipoSistemaOperativoMovilBuscar, int tamanoRamMovilBuscar) throws ExcepcionBuscarMovil;

    public void mostrarMarcas();

    public void mostrarArticulos();

} //Fin de la clase Operaciones
