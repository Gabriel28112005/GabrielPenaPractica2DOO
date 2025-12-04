package serviceImpl;

import java.util.Scanner;

import exceptions.*;
import models.*;
import service.*;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    boolean salir = false;
    Operaciones operaciones = new Operaciones();

    public void mostrarMenu(){
        while (!salir){
            try{
                System.out.print("Gestionamos un catálogo de televisores y móviles. Tenemos las siguientes opciones:\n");
                System.out.print(" 1. Añadir Marca\n");
                System.out.print(" 2. Añadir Televisior\n");
                System.out.print(" 3. Añadir Móvil\n");
                System.out.print(" 4. Buscar Marca\n");
                System.out.print(" 5. Buscar Televisor\n");
                System.out.print(" 6. Buscar Móvil\n");
                System.out.print(" 7. Listar Marcas\n");
                System.out.print(" 8. Listar Artículos\n");
                System.out.print(" 9. Salir\n");
                System.out.print("\nSabiendo que no se podrá añadir un televisor o móvil si no se ha registrado anteriormente la marca a la que pertenece, seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer después de leer el número

                if(opcion==1){
                    anadirMarca();
                } else if(opcion==2){
                    anadirTelevisor();
                } else if(opcion==3){
                    anadirMovil();
                } else if(opcion==4){
                    buscarMarca();
                } else if(opcion==5){
                    buscarTelevisor();
                } else if(opcion==6){
                    buscarMovil();
                } else if(opcion==7){
                    listarMarcas();
                } else if(opcion==8){
                    listarArticulos();
                } else if(opcion==9){
                    System.out.print("\nSaliendo del programa...\n");
                    salir = true; //Sale del bucle --> Finaliza el programa.
                } else{
                    throw new ExcepcionMostrarMenu("\nOpción no válida. Volviendo al menú...\n\n");
                }
            }catch (ExcepcionMostrarMenu e) {
                System.out.print(e.getMessage());
            }catch (ExcepcionAnadirMarca e) {
                System.out.print(e.getMessage());
            }catch (ExcepcionAnadirMovil e) {
                System.out.print(e.getMessage());
            }catch (ExcepcionAnadirTelevisor e) {
                System.out.print(e.getMessage());
            }catch (ExcepcionBuscarMarca e) {
                System.out.print(e.getMessage());
            }catch (ExcepcionBuscarMovil e) {
                System.out.print(e.getMessage());
            }catch (ExcepcionBuscarTelevisor e) {
                System.out.print(e.getMessage());
            }catch (ExcepcionListarArticulos e) {
                System.out.print(e.getMessage());
            }catch (ExcepcionListarMarcas e) {
                System.out.print(e.getMessage());
            }catch(Exception e){
                System.out.println("\nError genérico, no ha ingresado un valor válido. Volviendo al menú...\n");
                scanner.nextLine(); //Limpiar buffer
            }
        }
    } //Fin de la función mostrarMenu

    public void anadirMarca() throws ExcepcionAnadirMarca {
        try {
            System.out.print("Ingrese el nombre de la marca: ");
            String nombreMarca = scanner.nextLine().toLowerCase().trim(); //Se guarda el String ingresado por el usuario en minúsculas y sin espacios.

            // Verificar si la marca ya existe
            if (operaciones.listaMarcas.stream().anyMatch(marca -> marca.getNombre().equals(nombreMarca))) {
                throw new ExcepcionAnadirMarca("La marca ya está registrada.");
            }

            System.out.print("Ingrese el país de la marca: ");
            String paisMarca = scanner.nextLine().toLowerCase().trim();

            System.out.print("Ingrese la facturación de la marca: ");
            int facturacionMarca = scanner.nextInt();
            if (facturacionMarca < 0) {
                throw new ExcepcionAnadirMarca("La facturación no puede ser negativa.");
            }

            operaciones.agregarMarca(nombreMarca, paisMarca, facturacionMarca);

        } catch (ExcepcionAnadirMarca e) {
            throw new ExcepcionAnadirMarca("Error al añadir la marca: " + e.getMessage() + "\n");
        } catch(Exception e){
            System.out.print("Error, no ha ingresado un valor válido. Volviendo al menú...\n");
        }
    } //Fin de la función anadirMarca

    private void anadirTelevisor() throws ExcepcionAnadirTelevisor{
        try{
            System.out.print("Ingrese el nombre de la marca del televisor: ");
            String nombreMarcaTelevisor = scanner.nextLine().toLowerCase().trim();

            if(operaciones.listaMarcas.stream().anyMatch(marca -> marca.getNombre().equals(nombreMarcaTelevisor))){
                System.out.print("Ingrese el precio del televisor: ");
                double precioTelevisor = scanner.nextDouble();
                if(precioTelevisor<0){
                    throw new ExcepcionAnadirTelevisor("El precio no puede ser negativo. Volviendo al menú...\n");
                }


                System.out.print("Ingrese el nombre del televisor: ");
                String nombreTelevisor = scanner.nextLine().toLowerCase().trim();

                System.out.print("Ingrese el tipo de pantalla del televisor (LED, OLED, QLED): ");
                String pantallaTelevisor = scanner.next().toUpperCase().trim();

                System.out.print("Ingrese el tamaño en pulgadas del televisor: ");
                int tamanoPulgadasTelevisor = scanner.nextInt();
                if(tamanoPulgadasTelevisor<0){
                    throw new ExcepcionAnadirTelevisor("El tamaño en pulgadas no puede ser negativo. Volviendo al menú...\n");
                } else if (tamanoPulgadasTelevisor==0){
                    throw new ExcepcionAnadirTelevisor("El tamaño en pulgadas del televisor no puede ser 0. Volviendo al menú...\n");
                }

                TipoPantalla tipoPantallaTelevisor = TipoPantalla.valueOf(pantallaTelevisor);
                Marca marcaTelevisor = operaciones.listaMarcas.stream()
                        .filter(marca -> marca.getNombre().equals(nombreMarcaTelevisor))
                        .findFirst()
                        .orElse(null);

                operaciones.agregarTelevisor(precioTelevisor, marcaTelevisor, nombreTelevisor, tipoPantallaTelevisor, tamanoPulgadasTelevisor);

            } else{
                throw new ExcepcionAnadirTelevisor("La marca ingresada no está registrada.");
            }

        }catch (ExcepcionAnadirTelevisor e){
            throw new ExcepcionAnadirTelevisor("Error al añadir el televisor: " + e.getMessage());
        }
        catch (Exception e){
            System.out.print("Error, no ha ingresado un valor válido. Volviendo al menú...\n");
        }

    } //Fin de la función anadirTelevisor



    private void anadirMovil() throws ExcepcionAnadirMovil{
        try{
            System.out.print("Ingrese el nombre de la marca del móvil: ");
            String nombreMarcaMovil = scanner.nextLine().toLowerCase().trim();

            if(operaciones.listaMarcas.stream().anyMatch(marca -> marca.getNombre().equals(nombreMarcaMovil))) {
                System.out.print("Ingrese el precio del móvil: ");
                double precioMovil = scanner.nextDouble();
                if(precioMovil<0){
                    throw new ExcepcionAnadirMovil("El precio no puede ser negativo. Volviendo al menú...\n");
                }

                System.out.print("Ingrese el nombre del móvil: ");
                String nombreMovil = scanner.nextLine().toLowerCase().trim();

                System.out.print("Ingrese el sistema operativo del móvil (ANDROID, IOS): ");
                String sistemaOperativoMovil = scanner.nextLine().toUpperCase().trim();

                System.out.print("Ingrese el tamaño de la RAM del móvil (en GB): ");
                int tamanoRamMovil = scanner.nextInt();
                if(tamanoRamMovil<0){
                    throw new ExcepcionAnadirMovil("El tamaño de la RAM no puede ser negativo. Volviendo al menú...\n");
                } else if(tamanoRamMovil==0){
                    throw new ExcepcionAnadirMovil("El tamaño de la RAM no puede ser 0. Volviendo al menú...\n");
                }

                TipoSistemaOperativo tipoSistemaOperativoMovil = TipoSistemaOperativo.valueOf(sistemaOperativoMovil);

                Marca marcaMovil = operaciones.listaMarcas.stream()
                        .filter(marca -> marca.getNombre().equals(nombreMarcaMovil))
                        .findFirst()
                        .orElse(null);

                operaciones.agregarMovil(precioMovil, marcaMovil, nombreMovil, tipoSistemaOperativoMovil, tamanoRamMovil);

            } else{
                throw new ExcepcionAnadirMovil("La marca ingresada no está registrada. Volviendo al menú...\n");
            }

        }catch (ExcepcionAnadirMovil e){
            throw new ExcepcionAnadirMovil("Error al añadir el movil: " + e.getMessage());
        }catch(Exception e){
            System.out.print("Error, no ha ingresado un valor válido. Volviendo al menú...\n");
        }
    } //Fin de la función anadirMovil





    private void buscarMarca() throws ExcepcionBuscarMarca{
        try{
            System.out.print("Ingrese el nombre de la marca a buscar: ");
            String nombreMarcaBuscar = scanner.nextLine().toLowerCase().trim();

            System.out.print("Ingrese el país de la marca: ");
            String paisMarcaBuscar = scanner.nextLine().toLowerCase().trim();

            if(operaciones.listaMarcas.stream().anyMatch(marca -> marca.getNombre().equals(nombreMarcaBuscar) && marca.getPais().equals(paisMarcaBuscar))){
                operaciones.busquedaMarca(nombreMarcaBuscar,paisMarcaBuscar);
            } else{
                throw new ExcepcionBuscarMarca("La marca ingresada no está registrada. Volviendo al menú...\n");
            }

        } catch (ExcepcionBuscarMarca e){
            throw new ExcepcionBuscarMarca("Error al buscar la marca: " + e.getMessage());
        } catch (Exception e){
            System.out.print("Error, no ha ingresado un valor válido. Volviendo al menú...\n");
        }
    } //Fin de la función buscarMarca





    private void buscarTelevisor() throws ExcepcionBuscarTelevisor{
        try{
            System.out.print("Ingrese el precio del televisor a buscar: ");
            double precioTelevisorBuscar = scanner.nextDouble();
            if(precioTelevisorBuscar<0){
                throw new ExcepcionBuscarTelevisor("El precio no puede ser negativo. Volviendo al menú...\n");
            }

            System.out.print("Ingrese el nombre de la marca del televisor a buscar: ");
            String nombreMarcaBuscar = scanner.nextLine();

            Marca marcaTelevisorBuscar = operaciones.listaArticulos.stream()
                    .filter(articulo -> articulo instanceof Televisor && articulo.getMarca().getNombre().equals(nombreMarcaBuscar))
                    .map(articulo -> articulo.getMarca())
                    .findFirst()
                    .orElse(null);

            System.out.print("Ingrese el nombre del televisor a buscar: ");
            String nombreTelevisorBuscar = scanner.nextLine().toLowerCase().trim();

            System.out.print("Ingrese el tipo de pantalla del televisor a buscar (LED, OLED, QLED): ");
            String pantallaTelevisorBuscar = scanner.next().toUpperCase().trim();
            TipoPantalla tipoPantallaTelevisorBuscar = TipoPantalla.valueOf(pantallaTelevisorBuscar);
            if(tipoPantallaTelevisorBuscar != TipoPantalla.LED && tipoPantallaTelevisorBuscar!=TipoPantalla.OLED && tipoPantallaTelevisorBuscar != TipoPantalla.QLED){
                throw new ExcepcionBuscarTelevisor("El tipo de pantalla ingresado no es válido. Volviendo al menú...\n");
            }

            System.out.print("Ingrese el tamaño en pulgadas del televisor a buscar: ");
            int tamanoPulgadasTelevisorBuscar = scanner.nextInt();
            if(tamanoPulgadasTelevisorBuscar<0){
                throw new ExcepcionBuscarTelevisor("El tamaño en pulgadas no puede ser negativo. Volviendo al menú...\n");
            } else if(tamanoPulgadasTelevisorBuscar==0){
                throw new ExcepcionBuscarTelevisor("El tamaño en pulgadas del televisor no puede ser 0. Volviendo al menú...\n");
            }

            operaciones.encontrarTelevisor(precioTelevisorBuscar, marcaTelevisorBuscar, nombreTelevisorBuscar, tipoPantallaTelevisorBuscar, tamanoPulgadasTelevisorBuscar);

        } catch (ExcepcionBuscarTelevisor e){
            throw new ExcepcionBuscarTelevisor("Error al buscar el televisor: " + e.getMessage());
        } catch (Exception e) {
            System.out.print("Error general en función buscarTelevisor. Volviendo al menú...\n");
        }

    } //Fin de la función buscarTelevisor





    private void buscarMovil() throws ExcepcionBuscarMovil{
        try{
            System.out.print("Ingrese el precio del móvil a buscar: ");
            double precioMovilBuscar = scanner.nextDouble();
            if(precioMovilBuscar<0){
                throw new ExcepcionBuscarMovil("El precio no puede ser negativo. Volviendo al menú...\n");
            }

            scanner.nextLine(); //Limpiar buffer

            System.out.print("Ingrese el nombre de la marca del móvil a buscar: ");
            String nombreMarcaBuscar = scanner.nextLine();
            Marca marcaMovilBuscar = operaciones.listaArticulos.stream()
                    .filter(articulo -> articulo instanceof Movil && articulo.getMarca().getNombre().equals(nombreMarcaBuscar))
                    .map(articulo -> articulo.getMarca())
                    .findFirst()
                    .orElse(null);

            System.out.print("Ingrese el nombre del móvil a buscar: ");
            String nombreMovilBuscar = scanner.nextLine().toLowerCase().trim();

            System.out.print("Ingrese el sistema operativo del móvil a buscar (ANDROID, IOS): ");
            String sistemaOperativoMovilBuscar = scanner.nextLine().toUpperCase().trim();
            TipoSistemaOperativo tipoSistemaOperativoMovilBuscar = TipoSistemaOperativo.valueOf(sistemaOperativoMovilBuscar);
            if(tipoSistemaOperativoMovilBuscar!= TipoSistemaOperativo.Android && tipoSistemaOperativoMovilBuscar != TipoSistemaOperativo.iOS){
                throw new ExcepcionBuscarMovil("El sistema operativo ingresado no es válido. Volviendo al menú...\n");
            }

            System.out.print("Ingrese el tamaño de la RAM del móvil a buscar (en GB): ");
            int tamanoRamMovilBuscar = scanner.nextInt();
            if(tamanoRamMovilBuscar<0){
                throw new ExcepcionBuscarMovil("El tamaño de la RAM no puede ser negativo. Volviendo al menú...\n");
            } else if (tamanoRamMovilBuscar == 0){
                throw new ExcepcionBuscarMovil("El tamaño de la RAM no puede ser 0. VOlviendo al menú...\n");
            }

            operaciones.busquedaMovil(precioMovilBuscar, marcaMovilBuscar, nombreMovilBuscar, tipoSistemaOperativoMovilBuscar, tamanoRamMovilBuscar);

        } catch( ExcepcionBuscarMovil e){
            throw new ExcepcionBuscarMovil("Error al buscar el movil: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.print("Error en función buscarMovil. Volviendo al menú...\n");
        }

    } //Fin de la función buscarMovil





    private void listarMarcas() throws ExcepcionListarMarcas {
        if(operaciones.listaMarcas.isEmpty()){
            throw new ExcepcionListarMarcas("No hay marcas registradas.\n");
        } else{
            operaciones.mostrarMarcas();
        }
    } //Fin de la función listarMarcas





    private void listarArticulos() throws ExcepcionListarArticulos{
        try{

            if(operaciones.listaArticulos.isEmpty()){
                throw new ExcepcionListarArticulos("No hay artículos registrados.\n");
            } else{
                operaciones.mostrarArticulos();
            }
        }catch(ExcepcionListarArticulos e){
            throw new ExcepcionListarArticulos("Error al listar los artículos: " + e.getMessage());
        }
    } //Fin de la función listarArticulos





} //Fin de la clase Menu